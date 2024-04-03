--PHONE 시퀀스 삭제

DROP SEQUENCE SEQ_PHONE_NO;

--PHONE 시퀀스 생성

CREATE SEQUENCE SEQ_PHONE_NO;

--PHONE 테이블 삭제

DROP TABLE PHONE CASCADE CONSTRAINTS;

--PHONE 테이블 생성

CREATE TABLE PHONE (
   NO               NUMBER              NOT NULL    PRIMARY KEY
    , MODEL_NAME   VARCHAR2(100)      NULL
    , GRADE           VARCHAR2(100)      NULL
    , GRADE_PRICE   NUMBER              NULL
);
---------------------------------------------------------------

--PURCHASE_LIST 시퀀스 삭제

DROP SEQUENCE SEQ_PURCHASE_LIST_NO;

--PURCHASE_LIST 시퀀스 생성

CREATE SEQUENCE SEQ_PURCHASE_LIST_NO;

--PURCHASE_LIST 테이블 삭제

DROP TABLE PURCHASE_LIST CASCADE CONSTRAINTS;

--PURCHASE_LIST 테이블 생성

CREATE TABLE PURCHASE_LIST
 (
    NO               NUMBER             NOT NULL    PRIMARY KEY
    , PHONE_NUMBER   VARCHAR2(100)      NOT NULL
    , MEMBER_ID      VARCHAR2(100)      NOT NULL 
    , SCRATCH_NUM    NUMBER 
    , BATTERY_NUM    NUMBER             NOT NULL
    , TOTAL_SCORE    NUMBER             NOT NULL
    , ENROLL_DATE    TIMESTAMP          DEFAULT SYSDATE   
 );
---------------------------------------------------------

--MODEL_CLASS 시퀀스 삭제

DROP SEQUENCE SEQ_MODEL_CLASST_NO;

--MODEL_CLASS 시퀀스 생성

CREATE SEQUENCE SEQ_MODEL_CLASST_NO;

--MODEL_CLASS 테이블 삭제

DROP TABLE MODEL_CLASS CASCADE CONSTRAINTS;

--MODEL_CLASS 테이블 생성

CREATE TABLE MODEL_CLASS (
    NO                  NUMBER                              PRIMARY KEY
   , GRADE               CHAR(1)                             NOT NULL
   , TOTAL_SCORE       VARCHAR(100)                          NOT NULL
    , ENROLL_DATE       TIMESTAMP      DEFAULT TO_CHAR(SYSDATE)     NOT NULL
);
------------------------------------------------------------------

--PRICE_SET 시퀀스 삭제

DROP SEQUENCE SEQ_PRICE_SET_NO;

--PRICE_SET 시퀀스 생성

CREATE SEQUENCE SEQ_PRICE_SET_NO;

--PRICE_SET 테이블 삭제

DROP TABLE PRICE_SET CASCADE CONSTRAINTS;

--PRICE_SET 테이블 생성

CREATE TABLE PRICE_SET (
    NO                  NUMBER          PRIMARY KEY
    , MODEL_NAME        VARCHAR2(100)   NOT   NULL
    , GRADE             CHAR(1)         NOT NULL
   , FIRST_PRICE       NUMBER           NOT   NULL
   , GRADE_PRICE       NUMBER          NOT NULL
   , PERCENTAGE        NUMBER          NOT NULL
);
-------------------------------------------------------------------------------------
--SCRATCH 시퀀스 삭제

DROP SEQUENCE SEQ_SCRATCH_NO;

--SCRATCH 시퀀스 생성

CREATE SEQUENCE SEQ_SCRATCH_NO;

--PHONE 테이블 삭제

DROP TABLE SCRATCH CASCADE CONSTRAINTS;

--PHONE 테이블 생성

CREATE TABLE SCRATCH (
    NUM           VARCHAR2(100)        PRIMARY KEY
    , SCORE       NUMBER        NOT NULL
    , ENROLLDATE  TIMESTAMP     DEFAULT SYSDATE     NOT NULL
);

-----------------------------------------------------------------------------------

--BATTERY 시퀀스 삭제

DROP SEQUENCE SEQ_BATTERY_NO;

--BATTERY 시퀀스 생성

CREATE SEQUENCE SEQ_BATTERY_NO;

--BATTERY 테이블 삭제

DROP TABLE BATTERY CASCADE CONSTRAINTS;

--BATTERY 테이블 생성

CREATE TABLE BATTERY (
    PERCENTAGE    VARCHAR2(100)        PRIMARY KEY
    , SCORE       NUMBER               NOT NULL
    , ENROLLDATE  TIMESTAMP            DEFAULT SYSDATE     NOT NULL
);


COMMIT;