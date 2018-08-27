create or replace function system_user_findbyid(p_id integer)
  returns refcursor
language plpgsql
as $$
DECLARE
  ref refcursor;
BEGIN
  OPEN ref FOR
  select su.id, su.name, su.family, su.e_mail, su.password,
         b.id, b.name, b.adress,
         s.id, s.name
  from system_users su, branches b, subdivisions s
  where su.branch_id = b.id and su.subdivision_id = s.id
    and su.id = p_id;
  RETURN ref;
END;
$$;

alter function system_user_findbyid(integer)
  owner to root;