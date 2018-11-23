### spring boot jpa 结合使用

1. Spring boot jpa 配置，将依赖jar包引入

   ```xml
   <!--jpa配置-->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-data-jpa</artifactId>
           </dependency>
   ```

2. application.properties中增加配置

   ```properties
   #spring jpa 配置
   spring.jpa.hibernate.ddl-auto = update
   spring.jpa.open-in-view = false
   ```

3. 实体类增加注解



   ```java
   package com.first.project.domain;
   
   
   import javax.persistence.*;
   
   @Entity
   @Table(name = "topic_main")
   public class Topic extends DbCommon{
   
       private static final long serialVersionUID = 4800615921476597884L;
   
       @Column(name = "topic_name",length = 50)
       private String topicName;
   
       @Column(name = "author",length = 50)
       private String author;
   
       @Column(name = "view_time")
       private Integer viewTime = 0;
   
       @Column(name = "click_time")
       private Integer clickTime = 0;
   
       @Column(name = "cover_img",length = 100)
       private String coverImg;
   
       @Column(name = "content",length = 1000)
       private String content;
   
       @Column(name = "title",length = 20)
       private String title;
   
       @Column(name = "is_top")
       private Integer isTop = 0;
   
       @Column(name = "is_excellent")
       private Integer isExcellent = 0;
   
       public String getTopicName() {
           return topicName;
       }
   
       public void setTopicName(String topicName) {
           this.topicName = topicName;
       }
   
       public String getAuthor() {
           return author;
       }
   
       public void setAuthor(String author) {
           this.author = author;
       }
   
       public Integer getViewTime() {
           return viewTime;
       }
   
       public void setViewTime(Integer viewTime) {
           this.viewTime = viewTime;
       }
   
       public Integer getClickTime() {
           return clickTime;
       }
   
       public void setClickTime(Integer clickTime) {
           this.clickTime = clickTime;
       }
   
       public String getCoverImg() {
           return coverImg;
       }
   
       public void setCoverImg(String coverImg) {
           this.coverImg = coverImg;
       }
   
       public String getContent() {
           return content;
       }
   
       public void setContent(String content) {
           this.content = content;
       }
   
       public Integer getIsTop() {
           return isTop;
       }
   
       public void setIsTop(Integer isTop) {
           this.isTop = isTop;
       }
   
       public Integer getIsExcellent() {
           return isExcellent;
       }
   
       public void setIsExcellent(Integer isExcellent) {
           this.isExcellent = isExcellent;
       }
   
       public String getTitle() {
           return title;
       }
   
       public void setTitle(String title) {
           this.title = title;
       }
   
   
   }
   
   ```

   - 因为id createTime updateTime都是共用的字段所以都抽取了出来，放在一个base类中。但是一开始继承的时候碰到一个问题。

     ```java
     Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.AnnotationException: No identifier specified for entity: com.first.project.domain.Topic
         at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean (AbstractAutowireCapableBeanFactory.java:1699)
         at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:573)
         at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:495)
         at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:317)
         at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:222)
         at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:315)
         at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:199)
         at org.springframework.context.support.AbstractApplicationContext.getBean (AbstractApplicationContext.java:1089)
         at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization (AbstractApplicationContext.java:859)
         at org.springframework.context.support.AbstractApplicationContext.refresh (AbstractApplicationContext.java:550)
         at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh (ServletWebServerApplicationContext.java:140)
         at org.springframework.boot.SpringApplication.refresh (SpringApplication.java:780)
         at org.springframework.boot.SpringApplication.refreshContext (SpringApplication.java:412)
         at org.springframework.boot.SpringApplication.run (SpringApplication.java:333)
         at org.springframework.boot.SpringApplication.run (SpringApplication.java:1277)
         at org.springframework.boot.SpringApplication.run (SpringApplication.java:1265)
         at com.first.project.BlogApplication.main (BlogApplication.java:16)
         at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
         at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
         at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
         at java.lang.reflect.Method.invoke (Method.java:498)
         at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:497)
         at java.lang.Thread.run (Thread.java:748)
     Caused by: org.hibernate.AnnotationException: No identifier specified for entity: com.first.project.domain.Topic
         at org.hibernate.cfg.InheritanceState.determineDefaultAccessType (InheritanceState.java:266)
         at org.hibernate.cfg.InheritanceState.getElementsToProcess (InheritanceState.java:211)
         at org.hibernate.cfg.AnnotationBinder.bindClass (AnnotationBinder.java:731)
         at org.hibernate.boot.model.source.internal.annotations.AnnotationMetadataSourceProcessorImpl.processEntityHierarchies (AnnotationMetadataSourceProcessorImpl.java:249)
         at org.hibernate.boot.model.process.spi.MetadataBuildingProcess$1.processEntityHierarchies (MetadataBuildingProcess.java:222)
         at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete (MetadataBuildingProcess.java:265)
         at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata (EntityManagerFactoryBuilderImpl.java:861)
         at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build (EntityManagerFactoryBuilderImpl.java:888)
         at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory (SpringHibernateJpaPersistenceProvider.java:57)
         at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory (LocalContainerEntityManagerFactoryBean.java:365)
         at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory (AbstractEntityManagerFactoryBean.java:390)
         at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet (AbstractEntityManagerFactoryBean.java:377)
         at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet (LocalContainerEntityManagerFactoryBean.java:341)
         at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods (AbstractAutowireCapableBeanFactory.java:1758)
         at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean (AbstractAutowireCapableBeanFactory.java:1695)
         at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:573)
         at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:495)
         at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:317)
         at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:222)
         at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:315)
         at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:199)
         at org.springframework.context.support.AbstractApplicationContext.getBean (AbstractApplicationContext.java:1089)
         at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization (AbstractApplicationContext.java:859)
         at org.springframework.context.support.AbstractApplicationContext.refresh (AbstractApplicationContext.java:550)
         at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh (ServletWebServerApplicationContext.java:140)
         at org.springframework.boot.SpringApplication.refresh (SpringApplication.java:780)
         at org.springframework.boot.SpringApplication.refreshContext (SpringApplication.java:412)
         at org.springframework.boot.SpringApplication.run (SpringApplication.java:333)
         at org.springframework.boot.SpringApplication.run (SpringApplication.java:1277)
         at org.springframework.boot.SpringApplication.run (SpringApplication.java:1265)
         at com.first.project.BlogApplication.main (BlogApplication.java:16)
         at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
         at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
         at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
         at java.lang.reflect.Method.invoke (Method.java:498)
         at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:497)
         at java.lang.Thread.run (Thread.java:748)
     ```

     下边是DbCommon

     ```java
     package com.first.project.domain;
     
     import javax.persistence.*;
     import java.util.Date;
     
     public abstract class DbCommon{
     
         private Long id;
     
         private Integer deleteFlag;
     
         private Date createDate;
     
         private Date updateDate;
     
         @Id
         @Column(name="id", updatable=false)
         @GeneratedValue(strategy= GenerationType.IDENTITY)
         public Long getId() {
             return id;
         }
     
         public void setId(Long id) {
             this.id = id;
         }
     
         public Integer getDeleteFlag() {
             return deleteFlag;
         }
     
         public void setDeleteFlag(Integer deleteFlag) {
             this.deleteFlag = deleteFlag;
         }
     
         public Date getCreateDate() {
             return createDate;
         }
     
         public void setCreateDate(Date createDate) {
             this.createDate = createDate;
         }
     
         public Date getUpdateDate() {
             return updateDate;
         }
     
         public void setUpdateDate(Date updateDate) {
             this.updateDate = updateDate;
         }
     }
     
     ```

     经过查询所知 需要再DbCommon类上增加一个注解 @MappedSuperclass即可成功启动

4. 接下来进行数据查询操作

   - 创建数据访问接口CustomRepository 继承PagingAndSortingRepository

     ```java
     @NoRepositoryBean
     public interface CustomRepository <T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
     
     }
     ```


   - 实现类 CustomRepositoryImpl

     ```java
     public class CustomRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
             implements CustomRepository<T,ID>{
     
     
         private final EntityManager entityManager;
     
     
         public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
             super(domainClass, em);
             this.entityManager = em;
         }
     }
     ```

   - 因为我们要自定义一个基础的repository,所以我们需要自己定义一个RepositoryFactory

     ```java
     public class CommonRepositoryFactoryBean <T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID>{
     
     
         /**
          * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
          *
          * @param repositoryInterface must not be {@literal null}.
          */
         public CommonRepositoryFactoryBean(Class repositoryInterface) {
             super(repositoryInterface);
         }
     
     
         @Override
         protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
             return new CommonRepositoryFactory(entityManager);
         }
     
         private static class CommonRepositoryFactory <T, ID extends Serializable> extends JpaRepositoryFactory {
     
     
             public CommonRepositoryFactory(EntityManager entityManager) {
                 super(entityManager);
             }
     
             @Override
             protected SimpleJpaRepository<T,ID> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
                 return new CustomRepositoryImpl<T,ID>((Class<T>)information.getDomainType(), entityManager);
             }
     
             //重写getRepositoryBaseClas方法并且获得当前自定义的Repository的实现类型
             @Override
             protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata){
                 return CustomRepositoryImpl.class;
             }
     
         }
     ```

   - 接下来我们要让spring在加载的时候找到我们的工厂，需要在启动类上增加EnableJpaRepositories注解

     ```java
     @EnableJpaRepositories(basePackages = "com.first.project.dao",repositoryFactoryBeanClass = CommonRepositoryFactoryBean.class)
     @SpringBootApplication
     //不启用数据源自动配置
     //@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
     public class BlogApplication {
     
         public static void main(String[] args) {
             SpringApplication.run(BlogApplication.class, args);
         }
     }
     ```

   - 使用用例如下

     ```java
     
     /**
     自定义类继承基础repository接口 这样可以使用jpa提供的接口方法 也可以在此类自定义方法
     **/
     @Repository
     public interface TopicDao extends CustomRepository<Topic,Long>{
     
     }
     
     ```

   - 在controller里使用

     ```java
     @RestController
     public class TopicController {
     
         private static final Logger log = LoggerFactory.getLogger(TopicController.class);
     
     
         @Autowired
         private TopicDao topicDao;
     
         @GetMapping("/topic/getTopicList")
         public AjaxJson getTopicList() {
             AjaxJson ajaxJson = new AjaxJson();
             try {
                 Topic topic = new Topic();
                 topic.setAuthor("张三");
                 topic.setContent("123456");
                 Date today = new Date();
                 topic.setCreateDate(today);
                 topic.setUpdateDate(today);
                 topic.setClickTime(0);
                 topicDao.save(topic);
     
                 List<Topic> topicList = (List<Topic>) topicDao.findAll();
     
                 Map<String, Object> resultMap = new HashMap<>(topicList.size());
                 resultMap.put("topicList", topicList);
                 ajaxJson.setObj(resultMap);
             } catch (Exception e) {
                 e.printStackTrace();
                 log.warn("获取列表失败");
             }
             return ajaxJson;
         }
     ```

     至此 spring boot与jpa自动整合完成。

5. 接下来详细介绍下用到的jpa的几个类

   - 

6. 

















































