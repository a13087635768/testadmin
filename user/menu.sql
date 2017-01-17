/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016/12/29 10:13:53                          */
/*==============================================================*/


alter table "t_Journalism"
   drop constraint FK_T_JOURNA_RELATIONS_T_SONCOL;

alter table "t_colume"
   drop constraint FK_T_COLUME_MENU_COLU_T_MENU;

alter table "t_soncolume"
   drop constraint FK_T_SONCOL_RELATIONS_T_JOURNA;

alter table "t_soncolume"
   drop constraint "FK_T_SONCOL_COLUME-SO_T_COLUME";

drop index "Relationship_4_FK";

drop table "t_Journalism" cascade constraints;

drop index "menu_colume_FK";

drop table "t_colume" cascade constraints;

drop table "t_menu" cascade constraints;

drop index "Relationship_3_FK";

drop index "colume-soncolume_FK";

drop table "t_soncolume" cascade constraints;

/*==============================================================*/
/* Table: "t_Journalism"                                        */
/*==============================================================*/
create table "t_Journalism" 
(
   "j_id"               VARCHAR2(256)        not null,
   "s_id"               VARCHAR2(256)        not null,
   "j_Journalism"       CLOB,
   "j_name"             VARCHAR2(256),
   "j_title"            VARCHAR2(256),
   constraint PK_T_JOURNALISM primary key ("j_id")
);

/*==============================================================*/
/* Index: "Relationship_4_FK"                                   */
/*==============================================================*/
create index "Relationship_4_FK" on "t_Journalism" (
   "s_id" ASC
);

/*==============================================================*/
/* Table: "t_colume"                                            */
/*==============================================================*/
create table "t_colume" 
(
   "c_id"               VARCHAR2(256)        not null,
   "id"                 VARCHAR2(256)        not null,
   "c_name"             VARCHAR2(256),
   "c_index"            NUMBER,
   constraint PK_T_COLUME primary key ("c_id")
);

/*==============================================================*/
/* Index: "menu_colume_FK"                                      */
/*==============================================================*/
create index "menu_colume_FK" on "t_colume" (
   "id" ASC
);

/*==============================================================*/
/* Table: "t_menu"                                              */
/*==============================================================*/
create table "t_menu" 
(
   "id"                 VARCHAR2(256)        not null,
   "menuname"           VARCHAR2(256),
   constraint PK_T_MENU primary key ("id")
);

comment on table "t_menu" is
'×ÜÀ¸Ä¿±í';

/*==============================================================*/
/* Table: "t_soncolume"                                         */
/*==============================================================*/
create table "t_soncolume" 
(
   "s_id"               VARCHAR2(256)        not null,
   "j_id"               VARCHAR2(256),
   "c_id"               VARCHAR2(256)        not null,
   "s_name"             VARCHAR2(256),
   "s_index"            NUMBER,
   constraint PK_T_SONCOLUME primary key ("s_id")
);

/*==============================================================*/
/* Index: "colume-soncolume_FK"                                 */
/*==============================================================*/
create index "colume-soncolume_FK" on "t_soncolume" (
   "c_id" ASC
);

/*==============================================================*/
/* Index: "Relationship_3_FK"                                   */
/*==============================================================*/
create index "Relationship_3_FK" on "t_soncolume" (
   "j_id" ASC
);

alter table "t_Journalism"
   add constraint FK_T_JOURNA_RELATIONS_T_SONCOL foreign key ("s_id")
      references "t_soncolume" ("s_id");

alter table "t_colume"
   add constraint FK_T_COLUME_MENU_COLU_T_MENU foreign key ("id")
      references "t_menu" ("id");

alter table "t_soncolume"
   add constraint FK_T_SONCOL_RELATIONS_T_JOURNA foreign key ("j_id")
      references "t_Journalism" ("j_id");

alter table "t_soncolume"
   add constraint "FK_T_SONCOL_COLUME-SO_T_COLUME" foreign key ("c_id")
      references "t_colume" ("c_id");

