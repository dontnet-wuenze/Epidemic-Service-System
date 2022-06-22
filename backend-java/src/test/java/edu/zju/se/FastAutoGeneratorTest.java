package edu.zju.se;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p>
 * 快速生成
 * </p>
 *
 * @author lanjerry
 * @since 2021-09-16
 */
public class FastAutoGeneratorTest {

  /**
   * 执行初始化数据库脚本
   */
  public static void before() throws SQLException {
    Connection conn = DATA_SOURCE_CONFIG.build().getConn();
    InputStream inputStream = FastAutoGenerator.class.getResourceAsStream("/db/schema-h2.sql");
    ScriptRunner scriptRunner = new ScriptRunner(conn);
    scriptRunner.setAutoCommit(true);
    scriptRunner.runScript(new InputStreamReader(inputStream));
    conn.close();
  }

  /**
   * 数据源配置
   */
  private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
          .Builder("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL", "root", "admin");

  /**
   * 执行 run
   */
  public static void main(String[] args) throws SQLException {
    before();
    FastAutoGenerator.create(DATA_SOURCE_CONFIG)
            // 全局配置
            .globalConfig(builder -> builder.author("Boris Li").outputDir(System.getProperty("user.dir") + "src/main/java"))
            // 包配置
            .packageConfig(builder -> builder.parent("edu.zju.se"))
            // 策略配置
            .strategyConfig((scanner, builder) -> builder.addInclude(scanner.apply("请输入表名,多个表名用,隔开")))
            /*
                模板引擎配置,默认 Velocity 可选模板引擎 Beetl 或 Freemarker
               .templateEngine(new BeetlTemplateEngine())
               .templateEngine(new FreemarkerTemplateEngine())
             */
            .templateEngine(new FreemarkerTemplateEngine())
            .execute();
  }
}
