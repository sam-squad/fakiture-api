package com.samsquad.fakitureapi.db;
public class PostgresqlConf {
    public final static String URL = System.getenv("FAKITURE_DB_URL");
    public final static String USERNAME = System.getenv("FAKITURE_DB_USERNAME") ;
    public final static String PASSWORD = System.getenv("FAKITURE_DB_PASSWORD") ;
}