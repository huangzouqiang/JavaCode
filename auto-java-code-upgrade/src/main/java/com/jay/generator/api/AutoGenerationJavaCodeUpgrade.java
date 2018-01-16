package com.jay.generator.api;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AutoGenerationJavaCodeUpgrade {
    private String templateDir=System.getProperty("user.dir") + "/auto-java-code-upgrade/src/main/template";
    private static Properties prop;
    private static String[][] fileNameArray = new String[3][2];

    static {
        fileNameArray[0][0] = "serviceTemplate.ftl";
        fileNameArray[0][1] = "Service.java";

        fileNameArray[1][0] = "serviceImplTemplate.ftl";
        fileNameArray[1][1] = "ServiceImpl.java";

        fileNameArray[2][0] = "controllerTemplate.ftl";
        fileNameArray[2][1] = "Controller.java";

        FileInputStream inStream  = null;
        try {
            inStream = new FileInputStream(new File(System.getProperty("user.dir") + "/auto-java-code-upgrade/src/main/resources/generatorConfig.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AutoGenerationJavaCodeUpgrade() {
    }

    public void autoGenerationJavaCode(String className,String autoGeneratedFile) throws IOException, TemplateException, ClassNotFoundException,
            SQLException {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("utf-8");

        String fileName = dealClassName(className);
        //设置模板文件路径
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        Map<String, Object> rootMap = new HashMap<String, Object>();
        rootMap.put("className", className);
        rootMap.put("packageName", getServicePackageName());
        rootMap.put("modelPackageName", getModelPackageName());
        rootMap.put("mapperPackageName", getDaoPackageName());
        File dir = new File(autoGeneratedFile + "/");
        //检查目录是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        for (int i = 0; i < fileNameArray.length; i++) {
            Template temp = cfg.getTemplate(fileNameArray[i][0]);
            File docFile = new File(autoGeneratedFile + "/" + fileName + fileNameArray[i][1]);

            Writer docout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            //输出文件
            temp.process(rootMap, docout);
        }
        System.out.println("==============文件生产成功===============");

    }

    /**
     * 将类名转换为文件名，java公共类名与其文件名应该相同，这里将首字母转换为大写 如operateLog 转换后为 OperateLog
     * @param className
     * @return
     */
    private String dealClassName(String className) {
        String first = className.substring(0, 1).toUpperCase();
        String rest = className.substring(1, className.length());
        String fileName = new StringBuffer(first).append(rest).toString();
        return fileName;
    }

    public String getServicePackageName() throws IOException {
        String servicePackage = prop.getProperty("serviceName");
        return servicePackage;
    }
    private String getModelPackageName() {
        String modelPackage = prop.getProperty("modelTargetPackage");
        return modelPackage;
    }
    private String getDaoPackageName() {
        String modelPackage = prop.getProperty("daoTargetPackage");
        return modelPackage;
    }
}
