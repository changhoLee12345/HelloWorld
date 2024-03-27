package co.yedam.mavenProject;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import co.yedam.mavenProject.vo.MemberVO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		try {
			Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();

			SqlSession session = factory.openSession(true);

			MemberVO ivo = new MemberVO("user06", "0000", "사용자5", "010-0000-9999");
//			session.insert("co.yedam.mavenProject.mapper.QueryMapper.insertMember", ivo);
			session.delete("co.yedam.mavenProject.mapper.QueryMapper.deleteMember", ivo.getMemId());

//			MemberVO mvo = session.selectOne("co.yedam.mavenProject.mapper.QueryMapper.selectMember", "user01");
//			System.out.println(mvo.toString());

			List<MemberVO> list = session.selectList("co.yedam.mavenProject.mapper.QueryMapper.memberList");

			if (list.size() > 0) {
				list.forEach(System.out::println);

			} else {
				System.out.println("no data.");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
