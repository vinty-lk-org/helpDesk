create function branch_find_all()
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
  b.adress as b_adress,
  s.id     as s_id,
  s.name   as s_name
from system_users su, branches b, subdivisions s
where su.branch_id = b.id
      and su.subdivision_id = s.id;
RETURN ref;
END;
$$;


create function system_user_find_all()
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
  b.id      as b_id,
  b.name    as b_name,
  b.address as b_address,
  s.id      as s_id,
  s.name    as s_name
from system_users su, branches b, subdivisions s
where su.branch_id = b.id
      and su.subdivision_id = s.id;
RETURN ref;
END;
$$;


create or replace function system_user_findby_email(s_email CHARACTER VARYING )
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
  b.id      as b_id,
  b.name    as b_name,
  b.address as b_address,
  s.id      as s_id,
  s.name    as s_name
from system_users su,
  branches b,
  subdivisions s
where su.branch_id = b.id
      and su.subdivision_id = s.id
      and su.e_mail = s_email;
RETURN ref;
END;
$$;

alter function system_user_findby_email( CHARACTER VARYING )
owner to root;

create or replace function system_user_findbyid(p_id integer )
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
  b.id      as b_id,
  b.name    as b_name,
  b.address as b_address,
  s.id      as s_id,
  s.name    as s_name
from system_users su, branches b, subdivisions s
where su.branch_id = b.id and su.subdivision_id = s.id
      and su.id = p_id;
RETURN ref;
END;
$$;

alter function system_user_findbyid( integer )
owner to root;


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
  t.status_id,
  l.id     as l_id,
  l.name   as l_name,
  s.id     as s_id,
  s.name   as s_name,
  s.family as s_family,
  s.e_mail as s_email,
  s.branch_id,
  s.subdivision_id,
  st.name
from tasks t,
  listeners l,
  system_users s,
  status st
where t.listener_id = l.id
      and t.system_user_id = s.id
      and t.status_id = st.id;
RETURN ref;
END;
$$;


create or replace function tasks_findbyid(p_id integer )
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
  l.id     as l_id,
  l.name   as l_name,
  s.id     as s_id,
  s.name   as s_name,
  s.family as s_family,
  s.e_mail as s_email,
  s.branch_id,
  s.subdivision_id,
  st.id    as status_id,
  st.name
from tasks t,
  listeners l,
  system_users s,
  status st
where t.listener_id = l.id
      and t.system_user_id = s.id
      and t.id = p_id
      and t.status_id = st.id;
RETURN ref;
END;
$$;

