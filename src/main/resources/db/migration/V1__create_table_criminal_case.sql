create table `criminal_case` (
  `id` int primary key auto_increment,
  `case_name` varchar(255) not null ,
  `occurred_time` bigint not null ,
  `case_information_id` int ,
  `procuracy_id` int
);