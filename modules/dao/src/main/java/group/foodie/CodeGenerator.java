//package group.foodie;
//
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.FileOutConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.TemplateConfig;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//import java.util.ArrayList;
//import java.util.List;
//
//// 需要的生成信息的时放开生成
//
//public class CodeGenerator {
//
//    public static void main(String[] args) throws InterruptedException {
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "\\modules\\dao\\src\\main\\java");
//        gc.setFileOverride(true);
//        gc.setActiveRecord(true);
//        gc.setEnableCache(false);// XML 二级缓存
//        gc.setBaseResultMap(true);// XML ResultMap
//        gc.setBaseColumnList(true);// XML columList
//        gc.setOpen(false);
//        gc.setAuthor("renmingyuan");
//
//
//        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        gc.setServiceName("%sService");
//        gc.setServiceImplName("%sServiceImpl");
//
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUrl("jdbc:mysql://localhost:3306/foodie?useSSL=false");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("group.foodie.dao");
//        pc.setMapper("mapper");
//        pc.setEntity("entity");
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "\\modules\\dao\\src\\main\\resources\\group\\foodie\\dao\\mapper\\"
//                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        //此处可以修改为您的表前缀
//        //strategy.setTablePrefix(new String[] { "tb_"});
//        // 表名生成策略
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        // 需要生成的表
//        strategy.setInclude(new String[]{"foodie"});
//        // 排除生成的表
//        //strategy.setExclude(new String[]{"test"});
//        strategy.setEntityLombokModel(true);
//
//        mpg.setStrategy(strategy);
//
//        // 执行生成
//        mpg.execute();
//    }
//
//}