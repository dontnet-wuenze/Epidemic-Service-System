/*
 * Copyright (c) 2011-2021, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package edu.zju.se;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.DB2TypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqliteTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * mybatis plus FastAutoGenerator
 *
 * @author L.cm, lanjerry
 * @since 2021-07-22
 */
public final class FastAutoGenerator {

  /**
   * 数据源配置 Builder
   */
  private final DataSourceConfig.Builder dataSourceConfigBuilder;

  /**
   * 全局配置 Builder
   */
  private final GlobalConfig.Builder globalConfigBuilder;

  /**
   * 包配置 Builder
   */
  private final PackageConfig.Builder packageConfigBuilder;

  /**
   * 策略配置 Builder
   */
  private final StrategyConfig.Builder strategyConfigBuilder;

  /**
   * 注入配置 Builder
   */
  private final InjectionConfig.Builder injectionConfigBuilder;

  /**
   * 模板配置 Builder
   */
  private final TemplateConfig.Builder templateConfigBuilder;

  /**
   * 模板引擎
   */
  private AbstractTemplateEngine templateEngine;

  private FastAutoGenerator(DataSourceConfig.Builder dataSourceConfigBuilder) {
    this.dataSourceConfigBuilder = dataSourceConfigBuilder;
    this.globalConfigBuilder = new GlobalConfig.Builder();
    this.packageConfigBuilder = new PackageConfig.Builder();
    this.strategyConfigBuilder = new StrategyConfig.Builder();
    this.injectionConfigBuilder = new InjectionConfig.Builder();
    this.templateConfigBuilder = new TemplateConfig.Builder();
  }


  public static FastAutoGenerator create(@NotNull String url, String username, String password) {
    return new FastAutoGenerator(new DataSourceConfig.Builder(url, username, password));
  }

  public static FastAutoGenerator create(@NotNull DataSourceConfig.Builder dataSourceConfigBuilder) {
    return new FastAutoGenerator(dataSourceConfigBuilder);
  }

  /**
   * 读取控制台输入内容
   */
  private final Scanner scanner = new Scanner(System.in);

  /**
   * 控制台输入内容读取并打印提示信息
   *
   * @param message 提示信息
   * @return
   */
  public String scannerNext(String message) {
    System.out.println(message);
    String nextLine = scanner.nextLine();
    if (StringUtils.isBlank(nextLine)) {
      // 如果输入空行继续等待
      return scanner.next();
    }
    return nextLine;
  }

  /**
   * 全局配置
   *
   * @param consumer 自定义全局配置
   * @return
   */
  public FastAutoGenerator globalConfig(Consumer<GlobalConfig.Builder> consumer) {
    consumer.accept(this.globalConfigBuilder);
    return this;
  }

  public FastAutoGenerator globalConfig(BiConsumer<Function<String, String>, GlobalConfig.Builder> biConsumer) {
    biConsumer.accept(message -> scannerNext(message), this.globalConfigBuilder);
    return this;
  }

  /**
   * 包配置
   *
   * @param consumer 自定义包配置
   * @return
   */
  public FastAutoGenerator packageConfig(Consumer<PackageConfig.Builder> consumer) {
    consumer.accept(this.packageConfigBuilder);
    return this;
  }

  public FastAutoGenerator packageConfig(BiConsumer<Function<String, String>, PackageConfig.Builder> biConsumer) {
    biConsumer.accept(message -> scannerNext(message), this.packageConfigBuilder);
    return this;
  }

  /**
   * 策略配置
   *
   * @param consumer 自定义策略配置
   * @return
   */
  public FastAutoGenerator strategyConfig(Consumer<StrategyConfig.Builder> consumer) {
    consumer.accept(this.strategyConfigBuilder);
    return this;
  }

  public FastAutoGenerator strategyConfig(BiConsumer<Function<String, String>, StrategyConfig.Builder> biConsumer) {
    biConsumer.accept(message -> scannerNext(message), this.strategyConfigBuilder);
    return this;
  }

  /**
   * 注入配置
   *
   * @param consumer 自定义注入配置
   * @return
   */
  public FastAutoGenerator injectionConfig(Consumer<InjectionConfig.Builder> consumer) {
    consumer.accept(this.injectionConfigBuilder);
    return this;
  }

  public FastAutoGenerator injectionConfig(BiConsumer<Function<String, String>, InjectionConfig.Builder> biConsumer) {
    biConsumer.accept(message -> scannerNext(message), this.injectionConfigBuilder);
    return this;
  }

  /**
   * 模板配置
   *
   * @param consumer 自定义模板配置
   * @return
   */
  public FastAutoGenerator templateConfig(Consumer<TemplateConfig.Builder> consumer) {
    consumer.accept(this.templateConfigBuilder);
    return this;
  }

  public FastAutoGenerator templateConfig(BiConsumer<Function<String, String>, TemplateConfig.Builder> biConsumer) {
    biConsumer.accept(message -> scannerNext(message), this.templateConfigBuilder);
    return this;
  }

  /**
   * 模板引擎配置
   *
   * @param templateEngine 模板引擎
   * @return
   */
  public FastAutoGenerator templateEngine(AbstractTemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
    return this;
  }

  public void execute() {
    new AutoGenerator(this.dataSourceConfigBuilder.build())
            // 全局配置
            .global(this.globalConfigBuilder.build())
            // 包配置
            .packageInfo(this.packageConfigBuilder.build())
            // 策略配置
            .strategy(this.strategyConfigBuilder.build())
            // 注入配置
            .injection(this.injectionConfigBuilder.build())
            // 模板配置
            .template(this.templateConfigBuilder.build())
            // 执行
            .execute(this.templateEngine);
  }

  public static void before() throws SQLException {
    Connection conn = DATA_SOURCE_CONFIG.build().getConn();
    InputStream inputStream = com.baomidou.mybatisplus.generator.FastAutoGenerator.class.getResourceAsStream("/db/schema-h2.sql");
    ScriptRunner scriptRunner = new ScriptRunner(conn);
    scriptRunner.setAutoCommit(true);
    scriptRunner.runScript(new InputStreamReader(inputStream));
    conn.close();
  }

  private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
      .Builder("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL", "root", "admin")
      .typeConvert(new SqliteTypeConvert());

  // 处理 all 情况
  protected static List<String> getTables(String tables) {
    return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
  }

  public static void main(String[] args) throws SQLException {
    before();
    FastAutoGenerator.create(DATA_SOURCE_CONFIG)
            // 全局配置
            .globalConfig(builder -> builder.author("Boris Li").disableOpenDir()
            .outputDir(System.getProperty("user.dir") + "/src/main/java/"))
            // 包配置
            .packageConfig(builder -> builder.parent("edu.zju.se"))
            // 策略配置
            .strategyConfig((scanner, builder) -> builder
                    .addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔?")))
                    .controllerBuilder().enableRestStyle().enableHyphenStyle()
                    .entityBuilder().enableTableFieldAnnotation().columnNaming(NamingStrategy.underline_to_camel)
                    .enableLombok().fileOverride().build())
            /*
                模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
               .templateEngine(new BeetlTemplateEngine())
               .templateEngine(new FreemarkerTemplateEngine())
             */
            .templateEngine(new FreemarkerTemplateEngine())
            .execute();
  }
}