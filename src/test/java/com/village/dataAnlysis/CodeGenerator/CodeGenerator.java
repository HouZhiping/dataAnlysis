package com.village.dataAnlysis.CodeGenerator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Scanner;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        makeCode();
        //shuxue inter
//        makeShuxue();
    }

    public static void makeCode(){

//        String modleName = scanner("模块名");
        final String modleName = "PictureType";
        final String tableName = "pm_type_info";
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 包配置
        PackageConfig pc = new PackageConfig();
        //默认也可以不设置
        pc.setEntity("domain.entity");
        pc.setMapper("domain.mapper");
        pc.setXml(null);

        //父包名
        pc.setParent("com.village.dataAnlysis");
//        pc.setModuleName("domian");
        mpg.setPackageInfo(pc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String outputDir = "C:/idea_code/dataAnlysis/src/main/java";
        gc.setOutputDir(outputDir);

        gc.setAuthor("h");
        gc.setOpen(false);
        gc.setIdType(IdType.NONE);
        gc.setFileOverride(true);//会覆盖原来的文件
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        /*gc.setControllerName(pc.getModuleName() + "Controller");//
        gc.setServiceName(pc.getModuleName() + "Service");
        gc.setServiceImplName(pc.getModuleName() + "ServiceImpl");
        gc.setEntityName(pc.getModuleName());
        gc.setMapperName(pc.getModuleName() + "Mapper");*/
        gc.setEntityName(pc.getModuleName());
        gc.setControllerName(modleName + "Controller");//
        gc.setServiceName("I" + modleName + "Service");
        gc.setServiceImplName(modleName + "ServiceImpl");
        gc.setEntityName(modleName+"Entity");
        gc.setMapperName(modleName + "Mapper");

        gc.setIdType(IdType.AUTO);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://122.51.4.234:3306/longqiao_info?serverTimezone=GMT%2B8");
        dsc.setSchemaName("longqiao_info");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("hzp123456");
        mpg.setDataSource(dsc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setInclude(scanner("表名"));
        strategy.setInclude(tableName);
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    public static void makeShuxue(){
        String modleName = scanner("模块名");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setEntity("po");
        pc.setParent("com.zhongli.devplatform");//devplatform
        mpg.setPackageInfo(pc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        String projectPath = "D:/test";//C:\java\idea_workplace\shuxue\src

//        gc.setOutputDir(projectPath + "/src");
        gc.setOutputDir("C:/java/idea_workplace/shuxue/src/main/java");



        gc.setAuthor("h");
        gc.setOpen(false);
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        /*gc.setControllerName(pc.getModuleName() + "Controller");//
        gc.setServiceName(pc.getModuleName() + "Service");
        gc.setServiceImplName(pc.getModuleName() + "ServiceImpl");
        gc.setEntityName(pc.getModuleName());
        gc.setMapperName(pc.getModuleName() + "Mapper");*/
        gc.setControllerName(modleName + "Controller");//
        gc.setServiceName("I" + modleName + "Service");
        gc.setServiceImplName(modleName + "ServiceImpl");
        gc.setEntityName(modleName+"PO");
        gc.setMapperName(modleName + "Mapper");

        gc.setIdType(IdType.AUTO);

//         gc.setXmlName("%sDao");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/longqiao_info?serverTimezone=GMT%2B8");
//        dsc.setSchemaName("longqiao_info");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("12345678");

        dsc.setUrl("jdbc:mysql://139.9.148.236:3306/shuxue?serverTimezone=GMT%2B8");
        dsc.setSchemaName("shuxue");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("zhongli#123");
        mpg.setDataSource(dsc);

        // 自定义配置
        /*InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };*/

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        /*focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });*/

       /* cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);*/

        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        templateConfig.setEntity("templates/entity2.java");
//        templateConfig.setService("");
//        templateConfig.setController("");

//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.mybatisplus.core.mapper");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(scanner("表名"));
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);



//        strategy.setTablePrefix(pc.getModuleName() + "_ppp");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


}
