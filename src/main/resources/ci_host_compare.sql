/**
界面表格展示需要使用的数据库表结构与数据
 */
/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.1.0

Source Schema         : CATH_THINKOPS

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-12 13:57:45
*/


-- ----------------------------
-- Table structure for CI_HOST_COMPARE
-- ----------------------------
DROP TABLE "CI_HOST_COMPARE";
CREATE TABLE "CI_HOST_COMPARE" (
  "ID"                NUMBER(16)         NOT NULL,
  "NAME"              VARCHAR2(64 BYTE)  NULL,
  "HOST_NAME"         VARCHAR2(32 BYTE)  NULL,
  "MANAGE_IP"         VARCHAR2(16 BYTE)  NULL,
  "CPU_FAMILY"        VARCHAR2(256 BYTE) NULL,
  "OPERATE_SYSTEM"    VARCHAR2(32 BYTE)  NULL,
  "OS_VERSION"        VARCHAR2(16 BYTE)  NULL,
  "SERIAL_NUMBER"     VARCHAR2(250 BYTE) NULL,
  "MANUFACTURER_TEXT" VARCHAR2(250 BYTE) NULL,
  "PHYSICAL_CPUS"     NUMBER(8)          NULL,
  "MEMORY_SIZE"       NUMBER(16)         NULL,
  "DISK_COUNT"        NUMBER(5)          NULL,
  "TOTAL_DISK_SIZE"   NUMBER(16)         NULL,
  "INM_COMPARE_STATE" NUMBER(1)          NULL,
  "INM_SYNC_TIME"     DATE               NULL,
  "INM_CHECK_STATUS"  NUMBER(1)          NULL,
  "INM_CHECK_USER"    VARCHAR2(16 BYTE)  NULL,
  "INM_CHECK_TIME"    DATE               NULL,
  "HOST_ID"           NUMBER(16)         NULL
)
LOGGING
NOCOMPRESS
NOCACHE;
COMMENT ON COLUMN "CI_HOST_COMPARE"."INM_COMPARE_STATE" IS '比对结果标识 1增加 2修改 2删除';
COMMENT ON COLUMN "CI_HOST_COMPARE"."INM_SYNC_TIME" IS '入库时间';
COMMENT ON COLUMN "CI_HOST_COMPARE"."INM_CHECK_STATUS" IS '审核状态 1待审核 2已审核';
COMMENT ON COLUMN "CI_HOST_COMPARE"."INM_CHECK_USER" IS '审核人,取审核的登录用户';
COMMENT ON COLUMN "CI_HOST_COMPARE"."INM_CHECK_TIME" IS '审核时间';
COMMENT ON COLUMN "CI_HOST_COMPARE"."HOST_ID" IS 'CI_HOST表的id字段';

-- ----------------------------
-- Records of CI_HOST_COMPARE
-- ----------------------------
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('3', '192.168.80.38', 'vdr', '192.168.80.38', 'Intel(R) Xeon(R) CPU           X5675  @ 3.07GHz', 'CentOS', '5.5',
        'VMware-56 4d ed 9e bd 79 a7 af-ef bb b9 5e 24 73 4f 30', 'VMware, Inc.', '4', '4140826624', NULL, NULL, '2',
   TO_DATE('2017-05-24 10:38:03', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-05-24 10:41:22', 'YYYY-MM-DD HH24:MI:SS'), '1');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('36', '192.168.80.208', NULL, '192.168.80.208', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3',
   TO_DATE('2017-06-04 01:00:38', 'YYYY-MM-DD HH24:MI:SS'), '1', NULL, NULL, '12');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('37', '192.168.80.209', NULL, '192.168.80.209', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3',
   TO_DATE('2017-06-04 01:00:38', 'YYYY-MM-DD HH24:MI:SS'), '1', NULL, NULL, '13');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('38', '192.168.80.151', NULL, '192.168.80.151', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3',
   TO_DATE('2017-06-04 01:00:38', 'YYYY-MM-DD HH24:MI:SS'), '1', NULL, NULL, '19');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('61', '192.168.80.210', 'ossoiplteesb3', '192.168.80.210', 'Intel(R) Xeon(R) CPU E7- 4820  @ 2.00GHz', 'RedHat',
         '6.2', 'VMware-42 1f ec 16 c4 27 7d 6b-19 1a af 47 82 01 f4 b2', 'VMware, Inc.', '4', '8255438848', NULL, NULL,
   '2', TO_DATE('2017-06-12 01:00:29', 'YYYY-MM-DD HH24:MI:SS'), '1', NULL, NULL, '14');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('21', '192.168.80.42', 'localhost4', '192.168.80.42', 'Intel(R) Xeon(R) CPU E7-4820 v2 @ 2.00GHz', 'RedHat', '7.1',
         'VMware-42 30 99 08 3b 7a ee 93-b4 2f c8 e9 de 06 38 16', 'VMware, Inc.', '4', '8203010048', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:18:34', 'YYYY-MM-DD HH24:MI:SS'), '9');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('22', '192.168.80.200 ', 'localhost', '192.168.80.200', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '7.1',
         'VMware-42 30 52 af 21 de 66 99-92 2c b8 5a 30 51 21 65', 'VMware, Inc.', '4', '3975151616', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:18:29', 'YYYY-MM-DD HH24:MI:SS'), '10');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('23', '192.168.80.206', NULL, '192.168.80.206', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '6.2',
         'VMware-42 1f 25 a6 a2 00 aa ea-60 5c 8d 92 a2 d9 39 bb', 'VMware, Inc.', '4', '8255438848', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:18:25', 'YYYY-MM-DD HH24:MI:SS'), '11');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('24', '192.168.80.210', 'ossoiplteesb3', '192.168.80.210', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat',
         '6.2', 'VMware-42 1f ec 16 c4 27 7d 6b-19 1a af 47 82 01 f4 b2', 'VMware, Inc.', '4', '8255438848', NULL, NULL,
   '2', TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:18:12', 'YYYY-MM-DD HH24:MI:SS'), '14');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('25', '192.168.80.211', 'ossoiplteesb4', '192.168.80.211', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat',
         '6.2', 'VMware-42 1f df b9 2a 06 25 e8-da a1 73 7e 85 36 bf b2', 'VMware, Inc.', '4', '8255438848', NULL, NULL,
   '2', TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:18:07', 'YYYY-MM-DD HH24:MI:SS'), '15');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('26', '192.168.80.218', NULL, '192.168.80.218', 'Intel(R) Xeon(R) CPU E7- 4820  @ 2.00GHz',
         '#Red Hat Enterprise  Server', '6.2', 'VMware-42 1f 4e a9 72 5b 52 b2-17 f2 69 43 59 39 52 75', 'VMware, Inc.',
         '4', '8255438848', NULL, NULL, '2', TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:18:16', 'YYYY-MM-DD HH24:MI:SS'), '16');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('27', '192.168.80.219', NULL, '192.168.80.219', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '6.2',
         'VMware-42 1f e4 cf d3 13 61 12-5b 74 95 1b dd 50 8b c2', 'VMware, Inc.', '4', '16727932928', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:18:01', 'YYYY-MM-DD HH24:MI:SS'), '17');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('28', '192.168.80.149', 'it01', '192.168.80.149', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '6.5',
         'VMware-42 30 19 65 eb 1b e3 c3-9f c5 a7 0d 1d 0d 9b 7b', 'VMware, Inc.', '4', '8255438848', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:17:57', 'YYYY-MM-DD HH24:MI:SS'), '18');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('29', '192.168.80.154', 'cluster1', '192.168.80.154', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '6.4',
         'VMware-42 1f b3 bf 44 34 d4 8b-19 51 20 de 1d e5 43 54', 'VMware, Inc.', '1', '8239710208', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:17:52', 'YYYY-MM-DD HH24:MI:SS'), '20');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('30', '192.168.80.192', 'it01', '192.168.80.192', 'Intel(R) Xeon(R) CPU E7- 4820  @ 2.00GHz', 'RedHat', '6.5',
         'VMware-42 1f fc f0 c5 d1 db 01-db a8 b9 7d 2c 30 ac fe', 'VMware, Inc.', '4', '4019191808', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:15:35', 'YYYY-MM-DD HH24:MI:SS'), '21');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('31', '192.168.80.191', 'it02', '192.168.80.191', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '6.5',
         'VMware-42 1f 6d b6 6a 76 dc cc-62 2a ca 31 02 51 c9 20', 'VMware, Inc.', '8', '8254390272', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:15:29', 'YYYY-MM-DD HH24:MI:SS'), '22');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('32', '192.168.80.96', 'web-app', '192.168.80.96', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '6.2',
         'VMware-56 4d c2 16 73 b5 5d 10-2f f4 16 c4 a2 53 cd 83', 'VMware, Inc.', '8', '8255438848', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:15:23', 'YYYY-MM-DD HH24:MI:SS'), '23');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('33', '192.168.80.95', 'oracle', '192.168.80.95', 'Intel(R) Xeon(R) CPU E7- 4820  @ 2.00GHz', 'RedHat', '6.2',
         'VMware-42 2c 0a 75 76 ae 83 64-9d 8a 0a c0 60 20 34 a2', 'VMware, Inc.', '8', '16725835776', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:15:17', 'YYYY-MM-DD HH24:MI:SS'), '24');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('34', '192.168.80.60', 'thinkops-api-gateway', '192.168.80.60', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat',
         '6.2', 'VMware-56 4d 76 b6 cf f2 80 e7-0b f6 e8 2f 29 69 ad d3', 'VMware, Inc.', '4', '6137315328', NULL, NULL,
   '2', TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:14:54', 'YYYY-MM-DD HH24:MI:SS'), '25');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('35', '192.168.80.41', 'swarm_41', '192.168.80.41', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '7.1',
         'VMware-42 30 9c f8 ee d3 9d 42-72 fb e6 46 32 d6 81 f3', 'VMware, Inc.', '4', '8203010048', NULL, NULL, '2',
   TO_DATE('2017-06-05 01:00:31', 'YYYY-MM-DD HH24:MI:SS'), '2', 'admin',
   TO_DATE('2017-06-05 09:14:45', 'YYYY-MM-DD HH24:MI:SS'), '8');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('41', '192.168.80.206', NULL, '192.168.80.206', 'Intel(R) Xeon(R) CPU E5-2650 0 @ 2.00GHz', 'RedHat', '6.2',
         'VMware-42 1f 25 a6 a2 00 aa ea-60 5c 8d 92 a2 d9 39 bb', 'VMware, Inc.', '4', '8255438848', NULL, NULL, '2',
   TO_DATE('2017-06-12 01:00:29', 'YYYY-MM-DD HH24:MI:SS'), '1', NULL, NULL, '11');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('42', '192.168.80.218', NULL, '192.168.80.218', 'Intel(R) Xeon(R) CPU E7-4820 v2 @ 2.00GHz',
         '#Red Hat Enterprise  Server', '6.2', 'VMware-42 1f 4e a9 72 5b 52 b2-17 f2 69 43 59 39 52 75', 'VMware, Inc.',
         '4', '8255438848', NULL, NULL, '2', TO_DATE('2017-06-12 01:00:29', 'YYYY-MM-DD HH24:MI:SS'), '1', NULL, NULL,
   '16');
INSERT INTO "CI_HOST_COMPARE" VALUES
  ('43', '192.168.80.219', NULL, '192.168.80.219', 'Intel(R) Xeon(R) CPU E7- 4820  @ 2.00GHz', 'RedHat', '6.2',
         'VMware-42 1f e4 cf d3 13 61 12-5b 74 95 1b dd 50 8b c2', 'VMware, Inc.', '4', '16727932928', NULL, NULL, '2',
   TO_DATE('2017-06-12 01:00:29', 'YYYY-MM-DD HH24:MI:SS'), '1', NULL, NULL, '17');

-- ----------------------------
-- Indexes structure for table CI_HOST_COMPARE
-- ----------------------------
CREATE INDEX "CI_HOST_COMPARE_INDEX1"
  ON "CI_HOST_COMPARE" ("MANAGE_IP" ASC)
LOGGING
VISIBLE;
CREATE INDEX "CI_HOST_COMPARE_INDEX2"
  ON "CI_HOST_COMPARE" ("HOST_ID" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table CI_HOST_COMPARE
-- ----------------------------
ALTER TABLE "CI_HOST_COMPARE"
  ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CI_HOST_COMPARE
-- ----------------------------
ALTER TABLE "CI_HOST_COMPARE"
  ADD PRIMARY KEY ("ID");
