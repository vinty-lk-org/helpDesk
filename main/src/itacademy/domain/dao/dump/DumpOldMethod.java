package itacademy.domain.dao.dump;

public class DumpOldMethod {


    //    @Override
//    public Optional<SystemUser> findById(Long id) {
//        String sql = "select\n" +
//                "  su.id,\n" +
//                "  su.name,\n" +
//                "  su.family,\n" +
//                "  su.e_mail,\n" +
//                "  su.password,\n" +
//                "  b.id as b_id,\n" +
//                "  b.name as b_name,\n" +
//                "  b.address as b_adress,\n" +
//                "  s.id as s_id,\n" +
//                "  s.name as s_name\n" +
//                "from system_users su, branches b, subdivisions s\n" +
//                "where su.branch_id = b.id\n" +
//                "      and su.subdivision_id = s.id" +
//                "      and su.id = ? ;";
//        try (Connection connection = ConnectionManager.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setLong(1, id);
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    if (resultSet.next()) {
//                        return Optional.of(createSystemUserFromResultSet(resultSet));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

}
