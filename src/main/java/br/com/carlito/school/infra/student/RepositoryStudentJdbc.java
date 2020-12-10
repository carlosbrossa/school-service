package br.com.carlito.school.infra.student;

import br.com.carlito.school.domain.student.StudenNotFound;
import br.com.carlito.school.domain.student.Cpf;
import br.com.carlito.school.domain.student.Email;
import br.com.carlito.school.domain.student.Phone;
import br.com.carlito.school.domain.student.RepositoryStudent;
import br.com.carlito.school.domain.student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryStudentJdbc implements RepositoryStudent {

    private final Connection connection;

    public RepositoryStudentJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        try {
            String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getCpf());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.execute();

            sql = "INSERT INTO PHONE VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            for(Phone phone : student.getPhones()) {
                preparedStatement.setString(1, phone.getDdd());
                preparedStatement.setString(2, phone.getNumber());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findByCPF(Cpf cpf) throws StudenNotFound {
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumber());

            ResultSet rs = ps.executeQuery();
            boolean find = rs.next();
            if (!find) {
                throw new StudenNotFound(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student encontrado = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM PHONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                encontrado.addPhone(ddd, number);
            }

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> listAll() {
        try {
            String sql = "SELECT id, cpf, nome, email FROM ALUNO";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                Cpf cpf = new Cpf(rs.getString("cpf"));
                String name = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Student student = new Student(cpf, name, email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                PreparedStatement psPhone = connection.prepareStatement(sql);
                psPhone.setLong(1, id);
                ResultSet rsPhone = psPhone.executeQuery();
                while (rsPhone.next()) {
                    String number = rsPhone.getString("number");
                    String ddd = rsPhone.getString("ddd");
                    student.addPhone(ddd, number);
                }

                students.add(student);
            }

            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
