package com.xue.servlet;

import java.util.List;

import com.xue.model.Student;
import com.xue.service.StudentService;
import com.xue.service.Impl.StudentServiceImpl;

public class TestStudent {
	public static void main(String[] args) {
		StudentService ss1 = new StudentServiceImpl();
		List<Student> list = ss1.findStuAndTea();
		for (Student student : list) {
			System.out.println("ѧ������:" + student.getName());
			
			System.out.println("��ʦ����" + student.getTeacher().getName());
		}
	}
/*1. Mybatis����еĳ��ñ�ǩ��
	(1).mapper��ǩ�����д�����붨����mapper��ǩ��
	(2).insert��ǩ����ʶ���SQL
	(3).update��ǩ����ʶ�޸�SQL
	(4).delete��ǩ����ʶɾ��SQL
	(5).select��ǩ����ʶ��ѯSQL
	(6).where��ǩ������where�ؼ���
	(7).if��ǩ�������ж�(ʵ�ֶ�̬SQL�Ļ���)

2. ��ǩ�еĳ������ԣ�
	(1).namespace���ԣ������ռ�(ӳ�����ӿ�)(�����ص㣡����)
	(2).id���ԣ�ӳ����󷽷��ķ�����
	(3).parameterType���ԣ�ӳ����󷽷��Ĳ�������(��ʡ��)
	(4).resultType���ԣ�ӳ����󷽷��ķ���ֵ����(ֻ�в�ѯ��Ҫд)

3. ʹ��Mybatis��дXML�ļ���ע�����
	(1).�����������Ƕ���ʱ��#{}����Ҫ���ö���ĳ�Ա��������ռλ����ֵ
	(2).�����������ǵ�һ����ʱ��#{}��ֻ�趨��value����
	(3).resultType�����ڽ���ӳ��ʱ�������������ֵ�����Ǽ��ϣ�ֻ�趨�弯������װ��������
	(4).ִ�в�ѯSQL���ʱ��Ϊ�˱�֤����ѯ�Ľ���ܹ�װ����Ա�����У����뽫��ѯ���ֶκͳ�Ա����������һ�£������һ�£���Ҫ�����

4. Mybatis������ģ����ѯ��
	(1).ͨ����ͳռλ��ռλ�����ݵ�������Ҫ�ֶ�ƴ��%
		where book_name like #{value}
	(2).ͨ��ƴ�ӷ�ƴ��SQL������${}
		where book_name like '%${value}%'
		ȱ�㣺������SQLע�빥��������������д��
	(3).ͨ��SQL����е�concat�������
		where book_name like concat('%', #{value}, '%')
		ȱ�㣺������ิ��
	(4).ͨ��Mybatis�Դ����﷨���ģ����ѯ
		where book_name like "%" #{value} "%"
		ȱ�㣺ֻ�������ַ�������������������������

5. Mybatis��#{}��${}������(�����ص㣡����)
	#{}��ռλ��(�Զ�������ƴ�ӵ�����)
	${}��ƴ�ӷ�(�����Զ�������ƴ�ӵ����ţ�����SQLע�빥��)

6. ��Mybatis�д��������ֶ������ʱ����δ���
	(1).ͨ�������ĽǱ��ж�
		#{0}, #{1}, #{2}........
	(2).ͨ���ڲ����м���@Paramע����ӳ�������
		@Param("name") String name, @Param("author") String author
				
		where book_name like "%" #{name} "%"
		and book_author like "%" #{author} "%"

7. ʲô��Mybaits�Ķ�̬SQL��ѯ��
	ͨ����SQL�м����ж���������һ��SQL�����Ը���������ͬ���Ӷ���ɲ�ͬ�Ĺ��ܣ����Ϊ��̬SQL
	
	<select id="findBookDynamic" resultType="com.asjy.model.Book">
		select 
			book_id id,
			book_name name,
			book_author author,
			book_price price
		from book
		<where>
			<!-- 
				where��ǩ�����ã�
					1. ���SQL�е�where�ؼ���
					2. ���where��ǩ�����е�����������������ôwhere�Զ�ʡ��
					3. where��ǩ���Զ����Խ�������and����or�ؼ���
			 -->
			 <!-- 
				ͨ��<if>��ǩ�����ж����������ָ�ִ��ʲô���ܣ�
			 -->
			 <if test="id != 0">
			 	<!-- 
			 		test���ԣ��ж�����(�����м����жϷ��űȽ�����)
			 			==   !=   &lt;(<)	&gt;(>)   &lt;=(<=)   &gt;=(>=)
			 	 -->
			 	 book_id = #{id}
			 </if>
			 
			 <if test="name != null and name != ''">
			 	and book_name like "%" #{name} "%"
			 </if>
			 
			 <if test="author != null and author != ''">
			 	and book_author like "%" #{author} "%"
			 </if>
		</where>
	</select>

8. Mybatis�еĳ���ע�⣿
	(1).@Paramע�⣺���������еĲ���ӳ�䵽XML�ļ��е�ռλ����(�����ڴ��������ж������ʱ)
	(2).@insertע�⣺����XML�ļ�ִ�����SQL����
	(3).@updateע�⣺����XML�ļ�ִ���޸�SQL����
	(4).@deleteע�⣺����XML�ļ�ִ��ɾ��SQL����
	(5).@selectע�⣺����XML�ļ�ִ�в�ѯSQL����

9. Mybatis�����ɶ���ѯ��
	(1). һ��һ��ʵ��������Ҫ������һ��ʵ����Ķ�������Ա���������磺ѧ������������ʦ����
		private int id;
		private String name;
		private double score;
		private int teacherId;
		//��ʵ�������֣����һ��һ��ѯӳ��
		//����һ��ʵ�����������Ա�������ɣ����磺ѧ�����м�������ζ���
		private Teacher teacher;


	<resultMap type="com.asjy.model.Student" id="stuAndTea">
		<!-- 
			resultMap��ǩ�������ǣ�����ѯ�����ݿ��ֶκͶ�Ӧʵ�����еĳ�Ա����һһӳ�䣬�ȼ����������
			id���ԣ���ʶresultMap��ǩ���������ظ�
			type���ԣ��ȼ���֮ǰ��resultType����
		 -->
		 <result column="student_id" property="id"/>
		 <!-- 
		 	result��ǩ�������ǽ�һ���ֶκ�һ��ʵ�����Ա����ӳ��
		 	column���ԣ���ӦSQL����ѯ���ֶ���
		 	property���ԣ���Ӧʵ�����Ա������
		  -->
		  <result column="student_name" property="name"/>
		  <result column="student_score" property="score"/>
		  <result column="stu" property="teacherId"/>
		  <association property="teacher" javaType="com.asjy.model.Teacher">
		  	<!-- 
		  		association��ǩ�����һ��һ����ӳ��ı�ǩ
		  		property���ԣ���Ӧ��ֵ�Ķ�������
		  		javaType���ԣ���������������
		  	 -->
		  	 <result column="tea" property="id"/>
		  	 <result column="teacher_name" property="name"/>
		  	 <result column="teacher_salary" property="salary"/>
		  </association>
	</resultMap>
	
	<select id="findStuAndTea" resultMap="stuAndTea">
		select 
			student_id,
			student_name,
			student_score,
			student.teacher_id stu,
			teacher.teacher_id tea,
			teacher_name,
			teacher_salary
		from student 
		inner join teacher
		on student.teacher_id = teacher.teacher_id
	</select>
		
	(2). һ�Զࣺʵ��������Ҫ������һ��ʵ����ļ��ϵ�����Ա���������磺��ʦ��������ѧ���༯��

	private int id;
	private String name;
	private double salary;
	
	//һ�Զࣺ������һ��ʵ����ļ���
	//���磺��ʦ��������ѧ������
	private List<Student> list;


	<resultMap type="com.asjy.model.Teacher" id="teaAndStu">
		<result column="tea" property="id"/>
		<result column="teacher_name" property="name"/>
		<result column="teacher_salary" property="salary"/>
		<collection property="list" ofType="com.asjy.model.Student">
			<!-- 
				ofType���ԣ������ļ���ʵ��������װ���ݵ�����
			 -->
			 <result column="student_id" property="id"/>
			 <result column="student_name" property="name"/>
			 <result column="student_score" property="score"/>
			 <result column="stu" property="teacherId"/>
		</collection>
	</resultMap>

	<select id="findTeaAndStu" resultMap="teaAndStu">
		select 
			teacher.teacher_id tea,
			teacher_name,
			teacher_salary,
			student_id,
			student_name,
			student_score,
			student.teacher_id stu
		from teacher 
		inner join student
		on teacher.teacher_id = student.teacher_id 
	</select>

10. Mybatis����������Ȩ�޹�����ѯ��
	<select id="findPermissionByUserId" resultMap="permission">
		select
			minor.permission_name minorPermissionName,
			major.permission_name majorPermissionName,
			minor.permission_url minorPermissionUrl
		from tbl_permission as major		
		inner join tbl_permission as minor
		on minor.parent_id = major.permission_id
		inner join tbl_userpermission
		on minor.permission_id = tbl_userpermission.permission_id
		inner join tbl_user
		on tbl_user.user_id = tbl_userpermission.user_id
		<where>
			<if test="userId != 0">
				tbl_user.user_id = #{userId}
			</if>
		</where>
	</select>

11. Mybatis����������ɾ����
	<delete id="deleteMany">
		delete from book 
		where no in
		<foreach collection="array" item="no" open="(" separator="," close=")">
			#{no}
			<!-- 
				foreach��ǩ������foreachѭ��
				collection���ԣ���ʾ��Ҫѭ��ʲô��ʽ������(array��list)
				item���ԣ���ѭ����ȡ���ı���
				open���ԣ�ѭ����ʲôʱ��ʼ
				separator���ԣ�ѭ��������֮��ķָ���
				close���ԣ�ѭ����ʲôʱ�����
			 -->
		</foreach>
	</delete>
*/
}
