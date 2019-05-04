# 新闻资讯分享
## 项目描述
该项目是采用Java EE开发的新闻资讯分享Web项目，主要实现用户注册登录后分享资讯或与他人进行互动。

## 项目技术
使用springboot构建web框架，使用Mybatis完成数据库交互

使用SringAop拦截器通过下发Token完成登录校验和权限拦截

使用redis实现用户对资讯的赞踩功能

通过redis实现异步队列实现站内信消息通知，减少用户等待时间

通过redis实现sns关注功能以及我的收藏


## 待思考的问题
### 功能上
1 通过爬虫自动填充新闻

2 热点新闻列表

3 用户评论积分等

### 性能上

1 服务器 

纵向扩展：升级硬件资源

横向扩展：使用多台服务器 使用nginx等对访问量过大的服务采用负载均衡，实现服务集群，提高服务的最大并发数，防止压力过大导致单个服务的崩溃！

2 应用程序和资源文件分离

应用服务只提供相应的数据服务，静态资源部署在指定的服务器上（Nginx服务器或者是CDN服务器上）

3 数据库性能：

优化SQL，优化索引，使用索引SQL等

4 MySQL主从复制，读写分离

读写分离就是只在主服务器上写，只在从服务器上读，基本原理是让主数据库处理事务性查询，而从数据库处理select查询。

数据库复制被用于把事务性查询（增删改）导致的改变更新同步到集群中的从数据库。

MySQL读写分离提升系统性能：

1、主从只负责各自的读和写，极大程度缓解X锁和S锁争用。

2、slave可以配置MyISAM引擎，提升查询性能以及节约系统开销。

3、master直接写是并发的，slave通过主库发送来的binlog恢复数据是异步的。

4、slave可以单独设置一些参数来提升其读的性能。

5、增加冗余，提高可用性。

5 缓存式的Web应用程序架构

在Web层和DB层之间加一层cache层。主要目的：减少数据库读取负担，提高数据读取速度。

Cache存取的媒介是内存，可以考虑采用分布式的cache层，这样更容易破除内存容量的限制，同时提高了灵活性。

如redis这种缓存数据库，可以每隔一段时间写入数据库一次。

6 数据库分库分表

对于访问极为频繁且数据量巨大的单表来说，首先要做的是减少单表的记录条数，以便减少数据查询所需的时间，提高数据库的吞吐，这就是所谓的分表【水平拆分】。在分表之前，首先需要选择适当的分表策略，使得数据能够较为均衡地分布到多张表中，并且不影响正常的查询。如依据某个数字类型字段基于特定数目取模，某个时间类型字段的范围。或者是某个字符类型字段的hash值。‘


分表能够解决单表数0据量过大带来的查询效率下降的问题，但是却无法给数据库的并发处理能力带来质的提升。面对高并发的读写访问，当数据库master服务器无法承载写操作压力时，不管如何扩展Slave服务器都是没有意义的，对数据库进行拆分，从而提高数据库写入能力，即分库【垂直拆分】。根据业务分库。将数据库想象成为由非常多个一大块一大块的“数据块”（表）组成。我们垂直的将这些“数据块”切开，然后将他们分散到多台数据库主机上面。
