insert into author(id, first_name, last_name) values(1, "Andrea", "Claro");
insert into post(id, title, body, author_id, posted_on) values(1, "Spring boot is awesome", "Blog post content", 1, CURRENT_DATE());
insert into post(id, title, body, author_id, posted_on) values(2, "Spring data rocks", "Blog post content", 1, CURRENT_DATE());
