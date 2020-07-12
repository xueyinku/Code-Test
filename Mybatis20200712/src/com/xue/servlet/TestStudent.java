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
			System.out.println("学生姓名:" + student.getName());
			
			System.out.println("老师姓名" + student.getTeacher().getName());
		}
	}
/*1. Mybatis框架中的常用标签？
	(1).mapper标签：所有代码必须定义在mapper标签中
	(2).insert标签：标识添加SQL
	(3).update标签：标识修改SQL
	(4).delete标签：标识删除SQL
	(5).select标签：标识查询SQL
	(6).where标签：代替where关键字
	(7).if标签：用作判断(实现动态SQL的基础)

2. 标签中的常用属性？
	(1).namespace属性：命名空间(映射代理接口)(面试重点！！！)
	(2).id属性：映射抽象方法的方法名
	(3).parameterType属性：映射抽象方法的参数类型(可省略)
	(4).resultType属性：映射抽象方法的返回值类型(只有查询需要写)

3. 使用Mybatis编写XML文件的注意事项？
	(1).当参数类型是对象时，#{}中需要放置对象的成员变量当作占位符的值
	(2).当参数类型是单一数据时，#{}中只需定义value即可
	(3).resultType属性在进行映射时，如果方法返回值类型是集合，只需定义集合中所装数据类型
	(4).执行查询SQL语句时，为了保证将查询的结果能够装进成员变量中，必须将查询的字段和成员变量名保持一致，如果不一致，需要起别名

4. Mybatis如何完成模糊查询？
	(1).通过传统占位符占位，传递的数据需要手动拼接%
		where book_name like #{value}
	(2).通过拼接符拼接SQL，利用${}
		where book_name like '%${value}%'
		缺点：会引来SQL注入攻击，不建议这种写法
	(3).通过SQL语句中的concat函数完成
		where book_name like concat('%', #{value}, '%')
		缺点：代码过余复杂
	(4).通过Mybatis自带的语法完成模糊查询
		where book_name like "%" #{value} "%"
		缺点：只适用于字符串参数，不适用于整数参数

5. Mybatis中#{}和${}的区别？(面试重点！！！)
	#{}：占位符(自动将数据拼接单引号)
	${}：拼接符(不会自动将数据拼接单引号，引来SQL注入攻击)

6. 当Mybatis中代理方法出现多个参数时该如何处理？
	(1).通过参数的角标判断
		#{0}, #{1}, #{2}........
	(2).通过在参数中加入@Param注解来映射参数名
		@Param("name") String name, @Param("author") String author
				
		where book_name like "%" #{name} "%"
		and book_author like "%" #{author} "%"

7. 什么是Mybaits的动态SQL查询？
	通过在SQL中加入判断条件，让一个SQL语句可以根据条件不同，从而完成不同的功能，则称为动态SQL
	
	<select id="findBookDynamic" resultType="com.asjy.model.Book">
		select 
			book_id id,
			book_name name,
			book_author author,
			book_price price
		from book
		<where>
			<!-- 
				where标签的作用：
					1. 替代SQL中的where关键字
					2. 如果where标签中所有的条件都不成立，那么where自动省略
					3. where标签会自动忽略紧随其后的and或者or关键字
			 -->
			 <!-- 
				通过<if>标签加入判断条件来区分该执行什么功能？
			 -->
			 <if test="id != 0">
			 	<!-- 
			 		test属性：判断条件(其中有几个判断符号比较特殊)
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

8. Mybatis中的常用注解？
	(1).@Param注解：将代理方法中的参数映射到XML文件中的占位符中(适用于代理方法中有多个参数时)
	(2).@insert注解：代替XML文件执行添加SQL命令
	(3).@update注解：代替XML文件执行修改SQL命令
	(4).@delete注解：代替XML文件执行删除SQL命令
	(5).@select注解：代替XML文件执行查询SQL命令

9. Mybatis如何完成多表查询？
	(1). 一对一：实体类中需要引入另一个实体类的对象当作成员变量，例如：学生类中引入老师对象
		private int id;
		private String name;
		private double score;
		private int teacherId;
		//从实体类入手：完成一对一查询映射
		//加入一个实体类对象当作成员变量即可！例如：学生类中加入班主任对象
		private Teacher teacher;


	<resultMap type="com.asjy.model.Student" id="stuAndTea">
		<!-- 
			resultMap标签：作用是，将查询的数据库字段和对应实体类中的成员变量一一映射，等价于起别名！
			id属性：标识resultMap标签，不允许重复
			type属性：等价于之前的resultType属性
		 -->
		 <result column="student_id" property="id"/>
		 <!-- 
		 	result标签：作用是将一个字段和一个实体类成员变量映射
		 	column属性：对应SQL语句查询的字段名
		 	property属性：对应实体类成员变量名
		  -->
		  <result column="student_name" property="name"/>
		  <result column="student_score" property="score"/>
		  <result column="stu" property="teacherId"/>
		  <association property="teacher" javaType="com.asjy.model.Teacher">
		  	<!-- 
		  		association标签：完成一对一关联映射的标签
		  		property属性：对应赋值的对象名称
		  		javaType属性：对象所属的类型
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
		
	(2). 一对多：实体类中需要引入另一个实体类的集合当作成员变量，例如：老师类中引入学生类集合

	private int id;
	private String name;
	private double salary;
	
	//一对多：引入另一个实体类的集合
	//例如：老师类中引入学生集合
	private List<Student> list;


	<resultMap type="com.asjy.model.Teacher" id="teaAndStu">
		<result column="tea" property="id"/>
		<result column="teacher_name" property="name"/>
		<result column="teacher_salary" property="salary"/>
		<collection property="list" ofType="com.asjy.model.Student">
			<!-- 
				ofType属性：关联的集合实体类中所装数据的类型
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

10. Mybatis如何完成主分权限关联查询？
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

11. Mybatis如何完成批量删除？
	<delete id="deleteMany">
		delete from book 
		where no in
		<foreach collection="array" item="no" open="(" separator="," close=")">
			#{no}
			<!-- 
				foreach标签：代替foreach循环
				collection属性：表示需要循环什么格式的数据(array，list)
				item属性：从循环中取到的变量
				open属性：循环从什么时候开始
				separator属性：循环的数据之间的分隔符
				close属性：循环从什么时候结束
			 -->
		</foreach>
	</delete>
*/
}
