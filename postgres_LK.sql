# TaskDaoImpl findAll

create function tasks_find_all()
  returns refcursor
  language plpgsql
as $$
  DECLARE
  ref refcursor;
BEGIN
OPEN ref FOR
select
  t.id,
  t.name,
  t.text,
  l.id as l_id,
  l.name as l_name,
  s.id  as s_id,
  s.name as s_name,
  s.family as s_family,
  s.e_mail as s_email,
  s.branch_id,
  s.subdivision_id
from tasks t,
  listeners l,
  system_users s
where t.listener_id = l.id
      and t.system_user_id = s.id;
RETURN ref;
END;
$$;

alter function tasks_find_all()
owner to root;

# TaskDaoImpl findById

create function tasks_findbyid(p_id integer)
  returns refcursor
  language plpgsql
as $$
  DECLARE
  ref refcursor;
BEGIN
OPEN ref FOR
select
  t.id,
  t.name,
  t.text,
  l.id as l_id,
  l.name as l_name,
  s.id  as s_id,
  s.name as s_name,
  s.family as s_family,
  s.e_mail as s_email,
  s.branch_id,
  s.subdivision_id
from tasks t,
  listeners l,
  system_users s
where t.listener_id = l.id
      and t.system_user_id = s.id
      and t.id = p_id;
RETURN ref;
END;
$$;

alter function tasks_findbyid()
owner to root;

# BranchDaoImpl findAll

create or replace function branch_find_all()
returns refcursor
language plpgsql
as $$
DECLARE
ref refcursor;
BEGIN
OPEN ref FOR
select
  su.id,
  su.name,
  su.family,
  su.e_mail,
  su.password,
  b.id     as b_id,
  b.name   as b_name,
  b.address as b_address,
  s.id     as s_id,
  s.name   as s_name
from system_users su, branches b, subdivisions s
where su.branch_id = b.id
      and su.subdivision_id = s.id;
RETURN ref;
END;
$$;

alter function branch_find_all()
owner to root;

# SystemUserDaoImpl findByEmail

create or replace function system_user_findby_email(e_mail CHARACTER VARYING)
returns refcursor
language plpgsql
as $$
DECLARE
ref refcursor;
BEGIN
OPEN ref FOR
select
  su.id,
  su.name,
  su.family,
  su.e_mail,
  su.password,
  b.id     as b_id,
  b.name   as b_name,
  b.address as b_address,
  s.id     as s_id,
  s.name   as s_name
from system_users su, branches b, subdivisions s
where su.branch_id = b.id and su.subdivision_id = s.id
      and su.e_mail = e_mail;
RETURN ref;
END;
$$;

alter function system_user_findby_email(CHARACTER VARYING)
owner to root;

# SystemUserDaoImpl findById

create or replace function system_user_findbyid(p_id integer)
returns refcursor
language plpgsql
as $$
DECLARE
ref refcursor;
BEGIN
OPEN ref FOR
select
  su.id,
  su.name,
  su.family,
  su.e_mail,
  su.password,
  b.id     as b_id,
  b.name   as b_name,
  b.address as b_address,
  s.id     as s_id,
  s.name   as s_name
from system_users su, branches b, subdivisions s
where su.branch_id = b.id and su.subdivision_id = s.id
      and su.id = p_id;
RETURN ref;
END;
$$;

alter function system_user_findbyid( integer )
owner to root;
