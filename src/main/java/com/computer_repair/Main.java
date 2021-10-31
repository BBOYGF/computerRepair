package com.computer_repair;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@MapperScan("com.computer_repair.mapper")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        autoCoding();
    }

    private static void autoCoding() {
        AutoGenerator generator = new AutoGenerator();
        String projectPath = System.getProperty("user.dir");
        // 设置FreemarkerTemplateEngine模板引擎
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        //全局设置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        //作者
        globalConfig.setAuthor("guofan");
        //打开输入目录
        globalConfig.setOpen(false);
        //xml开启BaseResultMap
        globalConfig.setBaseResultMap(true);
        //xml开启BaseColumnList
        globalConfig.setBaseColumnList(true);
        //实体属性Swagger2注解
        globalConfig.setSwagger2(true);
        generator.setGlobalConfig(globalConfig);
        //配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //需要修改
        dataSourceConfig.setUrl("jdbc:mysql://101.34.107.75:3306/computer_repair_shop?userUnicode=true&characterEncoding=utf-8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("guofan123456");

        //添加数据源
        generator.setDataSource(dataSourceConfig);
        //包配置
        PackageConfig pc = new PackageConfig();
        // 需要修改
        pc.setParent("com.computer_repair")
                .setEntity("pojo")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller");
        //设置包
        generator.setPackageInfo(pc);
        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        //如果模板引擎是freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        //自定义输出配置
        List focList = new ArrayList<>();
        //自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        generator.setTemplate(templateConfig);
        //策略设置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的名字策略  下划线转换成驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //lombok模型
        strategy.setEntityLombokModel(true);
        //生成@RestController控制器
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分隔").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        //表前缀
        strategy.setTablePrefix("t_");
        //添加策略
        generator.setStrategy(strategy);
        generator.execute();
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (ipt != null || "".equals(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }
}
