-- 테이블 생성
CREATE TABLE STUDENT (
	ID	NUMBER(10)		NOT NULL,
	DEPT_ID	NUMBER(10)		NOT NULL,
	PASSWORD	VARCHAR(30)		NOT NULL,
	NAME	VARCHAR2(30)		NOT NULL,
	BIRTH_DATE	DATE		NOT NULL,
	GENDER	CHAR(1)		NOT NULL,
	ADDRESS	VARCHAR2(100)		NULL,
	TEL	VARCHAR(13)		NULL,
	GRADE	NUMBER(1)		NOT NULL,
	SEMESTER	NUMBER(1)		NOT NULL,
	ENTRANCE_DATE	DATE		NOT NULL,
	GRADUATION_DATE	DATE		NULL
);

CREATE TABLE STAFF (
	ID	NUMBER(10)		NOT NULL,
	PASSWORD	VARCHAR(30)		NOT NULL,
	NAME	VARCHAR2(30)		NOT NULL,
	BIRTH_DATE	DATE		NOT NULL,
	GENDER	CHAR(1)		NOT NULL,
	ADDRESS	VARCHAR2(100)		NULL,
	TEL	VARCHAR(13)		NULL,
	HIRE_DATE	DATE		NULL,
	DEPT	VARCHAR2(20)		NULL
);

CREATE TABLE PROFESSOR (
	ID	NUMBER(10)		NOT NULL,
	PASSWORD	VARCHAR(30)		NOT NULL,
	NAME	VARCHAR2(30)		NOT NULL,
	BIRTH_DATE	DATE		NOT NULL,
	GENDER	CHAR(1)		NOT NULL,
	ADDRESS	VARCHAR2(100)		NULL,
	TEL	VARCHAR(13)		NULL,
	HIRE_DATE	DATE		NULL,
	DEPT_ID	NUMBER(10)		NOT NULL
);

CREATE TABLE DEPARTMENT (
	ID	NUMBER(10)		NOT NULL,
	NAME	VARCHAR2(30)		NOT NULL,
	COLLEGE	VARCHAR2(30)		NOT NULL,
	AMOUNT	NUMBER(20)		NOT NULL
);

CREATE TABLE SUBJECT (
	ID	NUMBER(10)		NOT NULL,
	DEPT_ID	NUMBER(10)		NOT NULL,
	PROFESSOR_ID	NUMBER(10)		NOT NULL,
	NAME	VARCHAR2(20)		NOT NULL,
	ROOM	VARCHAR2(20)		NULL,
	TYPE	VARCHAR2(10)		NOT NULL,
	YEAR	NUMBER(4)		NOT NULL,
	SEMESTER	NUMBER(1)		NOT NULL,
	TIME	VARCHAR2(30)		NULL,
	GRADES	NUMBER(3)		NOT NULL
);

CREATE TABLE GRADE (
	ID	NUMBER(10)		NOT NULL,
	GRADE_VALUE	FLOAT		NOT NULL
);

CREATE TABLE TUITION (
	ID	NUMBER(10)		NOT NULL,
	SEMESTER	VARCHAR2(20)		NOT NULL,
	YEAR	VARCHAR2(20)		NOT NULL,
	STATUS	NUMBER(1)		NOT NULL
);

CREATE TABLE STU_STA (
	ID	NUMBER(10)		NOT NULL,
	STATUS	VARCHAR2(10)		NOT NULL,
	FROM_DATE	DATE		NULL,
	TO_DATE	DATE		NULL
);

CREATE TABLE NOTICE (
	ID	NUMBER(5)		NOT NULL,
	STAFF_ID	NUMBER(10)		NOT NULL,
	TITLE	VARCHAR(50)		NOT NULL,
	CONTENT	VARCHAR2(4000)		NULL,
	VIEWS	NUMBER(20)		NULL,
	CREATED	DATE		NULL
);

CREATE TABLE NOTICE_FILE (
	ORIGIN_FILENAME	VARCHAR2(100)		NULL,
	FILENAME	VARCHAR2(225)		NULL,
	ID	NUMBER(5)		NOT NULL
);

ALTER TABLE STUDENT ADD CONSTRAINT PK_STUDENT PRIMARY KEY (
	ID
);

ALTER TABLE STAFF ADD CONSTRAINT PK_STAFF PRIMARY KEY (
	ID
);

ALTER TABLE PROFESSOR ADD CONSTRAINT PK_PROFESSOR PRIMARY KEY (
	ID
);

ALTER TABLE DEPARTMENT ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY (
	ID
);

ALTER TABLE SUBJECT ADD CONSTRAINT PK_SUBJECT PRIMARY KEY (
	ID
);

ALTER TABLE GRADE ADD CONSTRAINT PK_GRADE PRIMARY KEY (
	ID
);

ALTER TABLE TUITION ADD CONSTRAINT PK_TUITION PRIMARY KEY (
	ID
);

ALTER TABLE STU_STA ADD CONSTRAINT PK_STU_STA PRIMARY KEY (
	ID
);

ALTER TABLE NOTICE ADD CONSTRAINT PK_NOTICE PRIMARY KEY (
	ID
);

ALTER TABLE NOTICE_FILE ADD CONSTRAINT PK_NOTICE_FILE PRIMARY KEY (
	ID
);


ALTER TABLE STUDENT ADD CONSTRAINT FK_DEPARTMENT_TO_STUDENT_1 FOREIGN KEY (
	DEPT_ID
)
REFERENCES DEPARTMENT (
	ID
);

ALTER TABLE PROFESSOR ADD CONSTRAINT FK_DEPARTMENT_TO_PROFESSOR_1 FOREIGN KEY (
	DEPT_ID
)
REFERENCES DEPARTMENT (
	ID
);

ALTER TABLE SUBJECT ADD CONSTRAINT FK_DEPARTMENT_TO_SUBJECT_1 FOREIGN KEY (
	DEPT_ID
)
REFERENCES DEPARTMENT (
	ID
);

ALTER TABLE SUBJECT ADD CONSTRAINT FK_PROFESSOR_TO_SUBJECT_1 FOREIGN KEY (
	PROFESSOR_ID
)
REFERENCES PROFESSOR (
	ID
);

ALTER TABLE TUITION ADD CONSTRAINT FK_STUDENT_TO_TUITION_1 FOREIGN KEY (
	ID
)
REFERENCES STUDENT (
	ID
);

ALTER TABLE STU_STA ADD CONSTRAINT FK_STUDENT_TO_STU_STA_1 FOREIGN KEY (
	ID
)
REFERENCES STUDENT (
	ID
);

ALTER TABLE NOTICE ADD CONSTRAINT FK_STAFF_TO_NOTICE_1 FOREIGN KEY (
	STAFF_ID
)
REFERENCES STAFF (
	ID
);

ALTER TABLE NOTICE ADD CONSTRAINT FK_NOTICE_FILE_TO_NOTICE_1 FOREIGN KEY (
	ID
)
REFERENCES NOTICE_FILE (
	ID
);

-- 시퀀스 생성
CREATE SEQUENCE STAFF_SEQ START WITH 24001 INCREMENT BY 1 NOMAXVALUE NOCACHE;
CREATE SEQUENCE PROFESSOR_SEQ START WITH 2400001 INCREMENT BY 1 NOMAXVALUE NOCACHE;
CREATE SEQUENCE STUDENT_SEQ START WITH 202400001 INCREMENT BY 1 NOMAXVALUE NOCACHE;
CREATE SEQUENCE NOTICE_SEQ START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

-- 임시 데이터 삽입
INSERT INTO STAFF (ID, PASSWORD, NAME, BIRTH_DATE, GENDER
                , ADDRESS, TEL, HIRE_DATE, DEPT)
VALUES (STAFF_SEQ.NEXTVAL, TO_CHAR(TO_DATE('2024-04-16', 'YYYY-MM-DD'), 'YYYYMMDD'), '홍길동', TO_DATE('2024-04-16', 'YYYY-MM-DD'), 'M'
     , '서울시', '010-1234-5678', TO_DATE('2024-04-16', 'YYYY-MM-DD'), 'HR')
;
     
INSERT INTO DEPARTMENT (ID, NAME, COLLEGE, AMOUNT)
VALUES (4112, '통계학과', '자연과학', 400)
;
     
INSERT INTO STUDENT (ID, DEPT_ID, PASSWORD, NAME, BIRTH_DATE
                  , GENDER, ADDRESS, TEL, GRADE, SEMESTER
                  , ENTRANCE_DATE, GRADUATION_DATE)
VALUES (STUDENT_SEQ.NEXTVAL, 4112, TO_CHAR(TO_DATE('2024-04-16', 'YYYY-MM-DD'), 'YYYYMMDD'), '이순신', TO_DATE('2024-04-16', 'YYYY-MM-DD')
      , 'M', '부산시', '010-0000-0000', 2, 1
      , TO_DATE('2024-04-16', 'YYYY-MM-DD'), TO_DATE('2024-04-16', 'YYYY-MM-DD'))
;

INSERT INTO PROFESSOR (ID, PASSWORD, NAME, BIRTH_DATE, GENDER
                     , ADDRESS, TEL, HIRE_DATE, DEPT_ID)
VALUES (PROFESSOR_SEQ.NEXTVAL, TO_CHAR(TO_DATE('2024-04-15', 'YYYY-MM-DD'), 'YYYYMMDD'), '김유신', TO_DATE('2024-04-16', 'YYYY-MM-DD'), 'M'
      , '용인시', '010-1111-1111', TO_DATE('2024-04-16', 'YYYY-MM-DD'), 4112)
;

COMMIT;
