--PHONE ������ ����

DROP SEQUENCE SEQ_PHONE_NO;

--PHONE ������ ����

CREATE SEQUENCE SEQ_PHONE_NO;

--PHONE ���̺� ����

DROP TABLE PHONE CASCADE CONSTRAINTS;

--PHONE ���̺� ����

CREATE TABLE PHONE (
   NO               NUMBER              NOT NULL    PRIMARY KEY
    , MODEL_NAME   VARCHAR2(100)      NULL
    , GRADE           VARCHAR2(100)      NULL
    , GRADE_PRICE   NUMBER              NULL
);
---------------------------------------------------------------

--PURCHASE_LIST ������ ����

DROP SEQUENCE SEQ_PURCHASE_LIST_NO;

--PURCHASE_LIST ������ ����

CREATE SEQUENCE SEQ_PURCHASE_LIST_NO;

--PURCHASE_LIST ���̺� ����

DROP TABLE PURCHASE_LIST CASCADE CONSTRAINTS;

--PURCHASE_LIST ���̺� ����

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

--MODEL_CLASS ������ ����

DROP SEQUENCE SEQ_MODEL_CLASST_NO;

--MODEL_CLASS ������ ����

CREATE SEQUENCE SEQ_MODEL_CLASST_NO;

--MODEL_CLASS ���̺� ����

DROP TABLE MODEL_CLASS CASCADE CONSTRAINTS;

--MODEL_CLASS ���̺� ����

CREATE TABLE MODEL_CLASS (
    NO                  NUMBER                              PRIMARY KEY
   , GRADE               CHAR(1)                             NOT NULL
   , TOTAL_SCORE       VARCHAR(100)                          NOT NULL
    , ENROLL_DATE       TIMESTAMP      DEFAULT TO_CHAR(SYSDATE)     NOT NULL
);
------------------------------------------------------------------

--PRICE_SET ������ ����

DROP SEQUENCE SEQ_PRICE_SET_NO;

--PRICE_SET ������ ����

CREATE SEQUENCE SEQ_PRICE_SET_NO;

--PRICE_SET ���̺� ����

DROP TABLE PRICE_SET CASCADE CONSTRAINTS;

--PRICE_SET ���̺� ����

CREATE TABLE PRICE_SET (
    NO                  NUMBER          PRIMARY KEY
    , MODEL_NAME        VARCHAR2(100)   NOT   NULL
    , GRADE             CHAR(1)         NOT NULL
   , FIRST_PRICE       NUMBER           NOT   NULL
   , GRADE_PRICE       NUMBER          NOT NULL
   , PERCENTAGE        NUMBER          NOT NULL
);
-------------------------------------------------------------------------------------
--SCRATCH ������ ����

DROP SEQUENCE SEQ_SCRATCH_NO;

--SCRATCH ������ ����

CREATE SEQUENCE SEQ_SCRATCH_NO;

--PHONE ���̺� ����

DROP TABLE SCRATCH CASCADE CONSTRAINTS;

--PHONE ���̺� ����

CREATE TABLE SCRATCH (
    NUM           VARCHAR2(100)        PRIMARY KEY
    , SCORE       NUMBER        NOT NULL
    , ENROLLDATE  TIMESTAMP     DEFAULT SYSDATE     NOT NULL
);

-----------------------------------------------------------------------------------

--BATTERY ������ ����

DROP SEQUENCE SEQ_BATTERY_NO;

--BATTERY ������ ����

CREATE SEQUENCE SEQ_BATTERY_NO;

--BATTERY ���̺� ����

DROP TABLE BATTERY CASCADE CONSTRAINTS;

--BATTERY ���̺� ����

CREATE TABLE BATTERY (
    PERCENTAGE    VARCHAR2(100)        PRIMARY KEY
    , SCORE       NUMBER               NOT NULL
    , ENROLLDATE  TIMESTAMP            DEFAULT SYSDATE     NOT NULL
);


COMMIT;