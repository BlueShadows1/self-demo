DELETE FROM user;


INSERT INTO user (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jone', 20, 'test2@baomidou.com'),
       (3, 'Jone', 20, 'test2@baomidou.com'),
       (4, 'Jone', 20, 'test2@baomidou.com'),
       (5, 'Jone', 20, 'test2@baomidou.com'),
       (6, 'Jone', 20, 'test2@baomidou.com'),
       (7, 'Jack', 20, 'test2@baomidou.com'),
       (8, 'Jack', 20, 'test2@baomidou.com'),
       (9, 'Jack', 20, 'test2@baomidou.com'),
       (10, 'Jack', 20, 'test2@baomidou.com'),
       (11, 'Jack', 20, 'test2@baomidou.com'),
       (12, 'Jack', 20, 'test2@baomidou.com'),
       (13, 'Jack', 20, 'test2@baomidou.com'),
       (14, 'Jack', 20, 'test2@baomidou.com'),
       (15, 'Tom', 28, 'test3@baomidou.com'),
       (16, 'Sandy', 21, 'test4@baomidou.com'),
       (17, 'Billie', 24, 'test5@baomidou.com');

insert into oauth2_client(clientId, clientSecret, redirectUrl, grantType, scope)
values ('clientId','clientSecret','http://www.baidu.com,http://www.csdn.net', 'authorization_code,client_credentials,password,implicit', 'scope1,scope2');

insert into oauth2_user (username, password)
values ('admin','admin');

insert into oauth2_user (username, password)
values ('guest','guest');




