#spring-batch-demo

#时间、请求url、用户、请求时长、userAgent
CREATE TABLE `access` (
  `date_str` varchar(50) NOT NULL,
  `path` varchar(200) NOT NULL,
  `userCode` varchar(100) NOT NULL,
  `time` int(11) DEFAULT NULL,
  `userAgent` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



#===============================================
本篇文件，我们来进一步学习Spring Batch3：读取解析日志文件并插入到数据库中。这是一个非常常见的场景：应用系统产生的日志，通过Spring Batch解析入库。
源文件

假定我们要读取的源文件的每行的格式如下（共5部分，用逗号分隔，分别为：时间、请求url、用户、请求时长、userAgent）：
2016-11-18 13:21:25,/test/core/postXY,sx_yuanchaozhong,4,/test/1.201610201/IOS/iPhone OS 10.0.2/iPhone8_1/31991EB3-60FF-4DCF-B90A-DE5E1F1026D7
目标表（mysql）

数据插入的表结构：
CREATE TABLE `access` (
  `date_str` varchar(50) NOT NULL,
  `path` varchar(200) NOT NULL,
  `userCode` varchar(100) NOT NULL,
  `time` int(11) DEFAULT NULL,
  `userAgent` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
Bean

为了方便解析和处理，我们增加一个javaBean实体类，对应日志文件中的每一行分隔后的数据：
public class AccessBean {
 private String dateStr;//日期字符串
 private String path;//路径
 private String userCode;//用户
 private Integer time;//请求时长（毫秒）
 private String userAgent;//客户端
//getter and setter ....
}
Spring Batch 代码实现

Spring Batch 实现包括三部分：ItemReader、ItemProcessor、ItemWriter

ItemReader实现：主要实现按行读取文件，分隔行并映射到实体类AccessBean中。Spring Batch3默认提供有很多常见的ItemReader，其中就包括我们所需要的ItemReader：org.springframework.batch.item.file.FlatFileItemReader，我们不需要自己实现。
ItemProcessor实现：由于我们是解析后直接插入数据库，不做处理，所以ItemProcessor不用实现
ItemWriter实现：把数据插入到数据库中。Spring Batch3默认也提供了我们所需要的ItemWriter：org.springframework.batch.item.database.JdbcBatchItemWriter，通过jdbc连接插入到数据库中。
Spring Batch3 默认提供了很多常见场景下的Reader和Writer的实现，所以很多场景下都不需要自己再实现。
Spring Batch Job配置

Job
<batch:job id="readFile2DBJob">
        <batch:step id="readFile2DBStep">
            <batch:tasklet>
                <batch:chunk reader="logReader" writer="mysqlItemWriter" commit-interval="1000" >
                </batch:chunk>
            </batch:tasklet>
        </batch:step>
    </batch:job>
commit-interval="1000" 指每读1000行进行处理（读1000行才会提交到Processor和Writer）
ItemReader - logReader
<!-- 文件读取Reader -->
    <bean id="logReader" class="org.springframework.batch.item.file.FlatFileItemReader">
        <!-- 要读取的资源文件 -->
        <property name="resource" value="file:/my/access.log"></property>
        <!-- 行处理 -->
        <property name="lineMapper">
            <bean class="org.springframework.batch.item.file.mapping.DefaultLineMapper">
                <!-- 行处理bean -->
                <property name="lineTokenizer" ref="accessLineTokenizer"></property>
                <!-- 行映射bean -->
                <property name="fieldSetMapper">
                    <!-- 通过lineTokenizer解析的结果会自动填充accessBean对象 -->
                    <bean class="org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper">
                        <property name="prototypeBeanName" value="accessBean"></property>
                    </bean>
                </property>
            </bean>
        </property>
    </bean>
FlatFileItemReader需要两个参数：resource和 lineMapper.而lineMapper同样需要两个参数：lineTokenizer和fieldSetMapper。

lineTokenizer :定义行的分隔方式和分隔后数据存储的方式，配置如下：
<!-- 行解析 -->
    <bean id="accessLineTokenizer" class="org.springframework.batch.item.file.transform.DelimitedLineTokenizer">
        <!-- 行按逗号分隔 -->
        <property name="delimiter" value=","></property>
        <!-- 分隔后的字段对应的key，注意顺序。这里配置5个，说明一行是由5部分组成的，如果某行逗号分隔后是4或者6，就会报错 -->
        <property name="names">
            <list>
                <value>dateStr</value>
                <value>path</value>
                <value>userCode</value>
                <value>time</value>
                <value>userAgent</value>
            </list>
        </property>
    </bean>
fieldSetMapper :定义如何映射行数据到实体类，这里通过BeanWrapperFieldSetMapper类来进行实体映射。

ItemWriter

 <!-- mysql Write -->
    <bean id="mysqlItemWriter" class="org.springframework.batch.item.database.JdbcBatchItemWriter">
        <!-- 数据源，这里使用了与spring batch元数据表同一个数据源，也可以根据实际情况换成任意数据源 -->
        <property name="dataSource" ref="dataSource" />
        <!-- 插入表的sql语句 -->
        <property name="sql">
            <value>
            <![CDATA[
               INSERT INTO access
                    (date_str, `path`, userCode, `time`, userAgent)
                    VALUES(:dateStr, :path, :userCode, :time, :userAgent)
            ]]>
            </value>
        </property>
        <!-- 匹配sql参数名与实体类accessBean属性 -->
        <property name="itemSqlParameterSourceProvider">
            <bean class="org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider" />
        </property>
    </bean>
运行Job
App.run("readFile2DBJob");
至此，读取文件插入数据库的工作已经全部完成。可以看出，开发的代码量很少。