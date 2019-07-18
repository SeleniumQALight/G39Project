package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDB {
    Database database;
    Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        database = new Database("MySQL_DB","MySQL");

    }
    @After
    public void tearDown() throws SQLException {
        database.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable =
                database.selectTable("select * from seleniumTable where login='keidanska@//'");
        logger.info(dataFromSeleniumTable);

        database.changeTable("INSERT INTO seleniumTable VALUES (88,'keidanska@//', 'pass')");

        dataFromSeleniumTable =
                database.selectTable("select * from seleniumTable where login='keidanska@//'");
        logger.info(dataFromSeleniumTable);
    }
}


