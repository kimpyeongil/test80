-- 프로젝트
DROP TABLE IF EXISTS PROJEC RESTRICT;

-- 멤버
DROP TABLE IF EXISTS MEMB RESTRICT;

-- 게시물
DROP TABLE IF EXISTS POSTS RESTRICT;

-- 강사
DROP TABLE IF EXISTS TEACHERS RESTRICT;

-- 매니저
DROP TABLE IF EXISTS MANAGERS RESTRICT;

-- 작업
DROP TABLE IF EXISTS TSK RESTRICT;

-- 클래스
DROP TABLE IF EXISTS CLASSES RESTRICT;

-- 클래스멤버
DROP TABLE IF EXISTS CLMEM RESTRICT;

-- 프로젝트멤버
DROP TABLE IF EXISTS PJMEMB RESTRICT;

-- 프로젝트
CREATE TABLE PROJEC (
  PNO   INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  PNM   VARCHAR(255) NOT NULL COMMENT '프로젝트명', -- 프로젝트명
  CONT  TEXT         NULL     COMMENT '프로젝트내용', -- 프로젝트내용
  ST_DT DATE         NULL     COMMENT '시작일', -- 시작일
  ED_DT DATE         NULL     COMMENT '종료일' -- 종료일
)
COMMENT '프로젝트';

-- 프로젝트
ALTER TABLE PROJEC
  ADD CONSTRAINT PK_PROJEC -- 프로젝트 기본키
    PRIMARY KEY (
      PNO -- 프로젝트번호
    );

-- 프로젝트 인덱스
CREATE INDEX IX_PROJEC
  ON PROJEC( -- 프로젝트
    PNM ASC -- 프로젝트명
  );

ALTER TABLE PROJEC
  MODIFY COLUMN PNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

ALTER TABLE PROJEC
  AUTO_INCREMENT = 1;

-- 멤버
CREATE TABLE MEMB (
  MNO   INTEGER     NOT NULL COMMENT '멤버번호', -- 멤버번호
  MNM   VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
  EMAIL VARCHAR(40) NOT NULL COMMENT '이메일', -- 이메일
  PWD   VARCHAR(20) NOT NULL COMMENT '암호', -- 암호
  TEL   VARCHAR(30) NULL     COMMENT '전화번호', -- 전화번호
  SUPER CHAR(1)     NULL     COMMENT '조장여부' -- 조장여부
)
COMMENT '멤버';

-- 멤버
ALTER TABLE MEMB
  ADD CONSTRAINT PK_MEMB -- 멤버 기본키
    PRIMARY KEY (
      MNO -- 멤버번호
    );

-- 멤버 유니크 인덱스
CREATE UNIQUE INDEX UIX_MEMB
  ON MEMB ( -- 멤버
    EMAIL ASC -- 이메일
  );

-- 멤버 인덱스
CREATE INDEX IX_MEMB
  ON MEMB( -- 멤버
    MNM ASC -- 이름
  );

ALTER TABLE MEMB
  MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '멤버번호';

ALTER TABLE MEMB
  AUTO_INCREMENT = 1;

-- 게시물
CREATE TABLE POSTS (
  WNO   INTEGER      NOT NULL COMMENT '게시물번호', -- 게시물번호
  TITLE VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  PNO   INTEGER      NULL     COMMENT '프로젝트번호', -- 프로젝트번호
  MNO   INTEGER      NULL     COMMENT '멤버번호', -- 멤버번호
  CONT  TEXT         NULL     COMMENT '내용', -- 내용
  VIEWS INTEGER      NULL     COMMENT '조회수', -- 조회수
  W_DT  DATE         NOT NULL COMMENT '게시일' -- 게시일
)
COMMENT '게시물';

-- 게시물
ALTER TABLE POSTS
  ADD CONSTRAINT PK_POSTS -- 게시물 기본키
    PRIMARY KEY (
      WNO -- 게시물번호
    );

ALTER TABLE POSTS
  MODIFY COLUMN WNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시물번호';

ALTER TABLE POSTS
  AUTO_INCREMENT = 1;

-- 강사
CREATE TABLE TEACHERS (
  TNO   INTEGER      NOT NULL COMMENT '강사번호', -- 강사번호
  TNM   VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  EMAIL VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  PWD   VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
  TEL   VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  PHOT  VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '강사';

-- 강사
ALTER TABLE TEACHERS
  ADD CONSTRAINT PK_TEACHERS -- 강사 기본키
    PRIMARY KEY (
      TNO -- 강사번호
    );

-- 강사 유니크 인덱스
CREATE UNIQUE INDEX UIX_TEACHERS
  ON TEACHERS ( -- 강사
    EMAIL ASC -- 이메일
  );

-- 강사 인덱스
CREATE INDEX IX_TEACHERS
  ON TEACHERS( -- 강사
    TNM ASC -- 이름
  );

ALTER TABLE TEACHERS
  MODIFY COLUMN TNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사번호';

ALTER TABLE TEACHERS
  AUTO_INCREMENT = 1;

-- 매니저
CREATE TABLE MANAGERS (
  MGNO  INTEGER      NOT NULL COMMENT '매니저번호', -- 매니저번호
  MGNM  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  EMAIL VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  PWD   VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
  TEL   VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  PHOT  VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '매니저';

-- 매니저
ALTER TABLE MANAGERS
  ADD CONSTRAINT PK_MANAGERS -- 매니저 기본키
    PRIMARY KEY (
      MGNO -- 매니저번호
    );

-- 매니저 유니크 인덱스
CREATE UNIQUE INDEX UIX_MANAGERS
  ON MANAGERS ( -- 매니저
    EMAIL ASC -- 이메일
  );

-- 매니저 인덱스
CREATE INDEX IX_MANAGERS
  ON MANAGERS( -- 매니저
    MGNM ASC -- 이름
  );

-- 매니저 인덱스2
CREATE INDEX IX_MANAGERS2
  ON MANAGERS( -- 매니저
  );

ALTER TABLE MANAGERS
  MODIFY COLUMN MGNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '매니저번호';

ALTER TABLE MANAGERS
  AUTO_INCREMENT = 1;

-- 작업
CREATE TABLE TSK (
  TANO  INTEGER      NOT NULL COMMENT '작업번호', -- 작업번호
  TNM   VARCHAR(255) NOT NULL COMMENT '작업명', -- 작업명
  PNO   INTEGER      NULL     COMMENT '프로젝트번호', -- 프로젝트번호
  MNO   INTEGER      NULL     COMMENT '멤버번호', -- 멤버번호
  CONT  TEXT         NULL     COMMENT '작업내용', -- 작업내용
  ST_DT DATE         NULL     COMMENT '시작일', -- 시작일
  ED_DT DATE         NULL     COMMENT '종료일' -- 종료일
)
COMMENT '작업';

-- 작업
ALTER TABLE TSK
  ADD CONSTRAINT PK_TSK -- 작업 기본키
    PRIMARY KEY (
      TANO -- 작업번호
    );

-- 작업 인덱스
CREATE INDEX IX_TSK
  ON TSK( -- 작업
    TNM ASC -- 작업명
  );

ALTER TABLE TSK
  MODIFY COLUMN TANO INTEGER NOT NULL AUTO_INCREMENT COMMENT '작업번호';

ALTER TABLE TSK
  AUTO_INCREMENT = 1;

-- 클래스
CREATE TABLE CLASSES (
  CNO  INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
  SUB  VARCHAR(255) NOT NULL COMMENT '과목', -- 과목
  NUM  INTEGER      NOT NULL COMMENT '기수', -- 기수
  TNO  INTEGER      NOT NULL COMMENT '강사번호', -- 강사번호
  MGNO INTEGER      NOT NULL COMMENT '매니저번호', -- 매니저번호
  ROOM INTEGER      NULL     COMMENT '강의실' -- 강의실
)
COMMENT '클래스';

-- 클래스
ALTER TABLE CLASSES
  ADD CONSTRAINT PK_CLASSES -- 클래스 기본키
    PRIMARY KEY (
      CNO -- 강의번호
    );

ALTER TABLE CLASSES
  MODIFY COLUMN CNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의번호';

ALTER TABLE CLASSES
  AUTO_INCREMENT = 1;

-- 클래스멤버
CREATE TABLE CLMEM (
  CNO INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
  MNO INTEGER NOT NULL COMMENT '멤버번호' -- 멤버번호
)
COMMENT '클래스멤버';

-- 클래스멤버
ALTER TABLE CLMEM
  ADD CONSTRAINT PK_CLMEM -- 클래스멤버 기본키
    PRIMARY KEY (
      CNO, -- 강의번호
      MNO  -- 멤버번호
    );

-- 프로젝트멤버
CREATE TABLE PJMEMB (
  PNO INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  MNO INTEGER NOT NULL COMMENT '멤버번호' -- 멤버번호
)
COMMENT '프로젝트멤버';

-- 프로젝트멤버
ALTER TABLE PJMEMB
  ADD CONSTRAINT PK_PJMEMB -- 프로젝트멤버 기본키
    PRIMARY KEY (
      PNO, -- 프로젝트번호
      MNO  -- 멤버번호
    );

-- 게시물
ALTER TABLE POSTS
  ADD CONSTRAINT FK_PJMEMB_TO_POSTS -- 프로젝트멤버 -> 게시물
    FOREIGN KEY (
      PNO, -- 프로젝트번호
      MNO  -- 멤버번호
    )
    REFERENCES PJMEMB ( -- 프로젝트멤버
      PNO, -- 프로젝트번호
      MNO  -- 멤버번호
    );

-- 작업
ALTER TABLE TSK
  ADD CONSTRAINT FK_PROJEC_TO_TSK -- 프로젝트 -> 작업
    FOREIGN KEY (
      PNO -- 프로젝트번호
    )
    REFERENCES PROJEC ( -- 프로젝트
      PNO -- 프로젝트번호
    );

-- 작업
ALTER TABLE TSK
  ADD CONSTRAINT FK_PJMEMB_TO_TSK -- 프로젝트멤버 -> 작업
    FOREIGN KEY (
      PNO, -- 프로젝트번호
      MNO  -- 멤버번호
    )
    REFERENCES PJMEMB ( -- 프로젝트멤버
      PNO, -- 프로젝트번호
      MNO  -- 멤버번호
    );

-- 클래스
ALTER TABLE CLASSES
  ADD CONSTRAINT FK_TEACHERS_TO_CLASSES -- 강사 -> 클래스
    FOREIGN KEY (
      TNO -- 강사번호
    )
    REFERENCES TEACHERS ( -- 강사
      TNO -- 강사번호
    );

-- 클래스
ALTER TABLE CLASSES
  ADD CONSTRAINT FK_MANAGERS_TO_CLASSES -- 매니저 -> 클래스
    FOREIGN KEY (
      MGNO -- 매니저번호
    )
    REFERENCES MANAGERS ( -- 매니저
      MGNO -- 매니저번호
    );

-- 클래스멤버
ALTER TABLE CLMEM
  ADD CONSTRAINT FK_CLASSES_TO_CLMEM -- 클래스 -> 클래스멤버
    FOREIGN KEY (
      CNO -- 강의번호
    )
    REFERENCES CLASSES ( -- 클래스
      CNO -- 강의번호
    );

-- 클래스멤버
ALTER TABLE CLMEM
  ADD CONSTRAINT FK_MEMB_TO_CLMEM -- 멤버 -> 클래스멤버
    FOREIGN KEY (
      MNO -- 멤버번호
    )
    REFERENCES MEMB ( -- 멤버
      MNO -- 멤버번호
    );

-- 프로젝트멤버
ALTER TABLE PJMEMB
  ADD CONSTRAINT FK_PROJEC_TO_PJMEMB -- 프로젝트 -> 프로젝트멤버
    FOREIGN KEY (
      PNO -- 프로젝트번호
    )
    REFERENCES PROJEC ( -- 프로젝트
      PNO -- 프로젝트번호
    );

-- 프로젝트멤버
ALTER TABLE PJMEMB
  ADD CONSTRAINT FK_MEMB_TO_PJMEMB -- 멤버 -> 프로젝트멤버
    FOREIGN KEY (
      MNO -- 멤버번호
    )
    REFERENCES MEMB ( -- 멤버
      MNO -- 멤버번호
    );