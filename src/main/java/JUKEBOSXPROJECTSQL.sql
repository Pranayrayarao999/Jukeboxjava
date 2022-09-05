create database JukeBoxProject;

use JukeBoxProject;

drop database JukeBoxProject;

create table songs(
songid varchar(15) primary key,
artistName varchar(50),
songName varchar(50),
songGenre varchar(50),
albumName varchar(50),
releaseDate varchar(25),
song_Duration varchar(25),
url varchar(100));

create table podcast(
podcastid varchar(15) primary key,
artistName varchar(50),
podcastName varchar(50),
podcastGenre varchar(50),
releaseDate varchar(25),
podcast_Duration varchar(25),
url varchar(100));

create table audio(
audioId varchar(15) primary key,
audio_type varchar(15),
podcastid varchar(15) references podcast (podcastid),
songid varchar(15) references songs (songid));


create table playlist
(
playlistId varchar(15) primary key,
userId varchar(15) references user (userid),
audioId varchar(15) references audio (audioid)
);

create table playlistrecords(
playlistId varchar(15) references playlist (playlistId),
audiotype varchar(25) references audio (audioid),
audioid varchar(15) references audio (audioid));


create table users(
userId varchar(15) primary key,
userName varchar(25),
user_password varchar(15)
);

drop table playlistrecords;

insert into songs
values('1',"allu arjun","srivalli","Rock","Pushpa",'2022-06-12','00:03:43',"D:\\Songs\\Srivalli.wav");

insert into songs
values('2','thalapathy vijay','habibo','Rock','Beast','2022-07-15','00:04:38','D:\\Songs\\halamithi-habibo-beast-128-kbps-sound.wav');

insert into podcast
values('p1','pa1','pn1','p1','2022-06-15','00:01:00','');

insert into audio
values('a1','song','null','1');

insert into audio
values('a2','song','null','2');

insert into users
values('u1','pranay','pranay');

select * from users;

select * from playlist;

insert into playlist
values('p1',"pranay",'a1');

insert into playlist
values('p2','u1','a2');

insert into playlistrecords
values('p1','song','a1');

insert into playlistrecords
values('p2','podcast','a2');

select * from playlist where userId ='?';
select * from users;

insert into playlist
values('p3','u1','a3');


