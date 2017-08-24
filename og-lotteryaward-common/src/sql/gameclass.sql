CREATE TABLE OG_LA.GAME_CLASS
(
  ID                     VARCHAR2(15 CHAR)      NOT NULL PRIMARY KEY,
  NAME                   VARCHAR2(50 CHAR),
  SORT_ID                NUMBER(10),
  DESCRIPTION            VARCHAR2(300 BYTE),
  CREATE_DATE            DATE
);

COMMENT ON COLUMN GAME_CLASS.ID IS '分类ID';

COMMENT ON COLUMN GAME_CLASS.NAME IS '分类名称';

COMMENT ON COLUMN GAME_CLASS.SORT_ID IS '分类排序';

COMMENT ON COLUMN GAME_CLASS.DESCRIPTION IS '描述';

COMMENT ON COLUMN GAME_CLASS.CREATE_DATE IS '创建时间';


INSERT INTO game_class values('K3','快3','1','',sysdate);
INSERT INTO game_class values('SSC','时时彩','2','',sysdate);
INSERT INTO game_class values('XX5','11选5','3','',sysdate);
INSERT INTO game_class values('LHC','六合彩','4','',sysdate);
INSERT INTO game_class values('BSC','北京赛车','5','',sysdate);
INSERT INTO game_class values('KL8','快乐彩','6','',sysdate);
commit;
