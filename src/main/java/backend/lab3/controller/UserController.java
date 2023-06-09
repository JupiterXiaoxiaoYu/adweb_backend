package backend.lab3.controller;

import backend.lab3.mybatis.SqlSessionLoader;
import backend.lab3.mybatis.po.User;
import backend.lab3.request.UserLoginRequest;
import backend.lab3.request.UserRegisterRequest;
import backend.lab3.response.ErrorResponse;
import backend.lab3.response.UserRegisterResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Object register(@RequestBody UserRegisterRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findUserByUsername", request.getUsername());
        if (user != null) {
            sqlSession.close();
            return new ErrorResponse("The username is already used");
        } else {
            sqlSession.insert("backend.lab3.mybatis.config.mapper.UserMapper.addUser",
                    new User(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhone()));
            sqlSession.commit();
            sqlSession.close();
            return new UserRegisterResponse("Register Successfully!");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Object login(@RequestBody UserLoginRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findUserByUsername", request.getUsername());
        if (user == null) {
            sqlSession.close();
            return new ErrorResponse("The username not exists, please register first");
        } else if (!user.getPassword().equals(request.getPassword())) {
            System.out.println();
            System.out.println(request.getPassword());
            System.out.println(user.getPassword()==request.getPassword());
            sqlSession.close();
            return new ErrorResponse("Incorrect password");
        }else{
            sqlSession.close();
            return new UserRegisterResponse("Login Successfully!");
        }
    }

    @RequestMapping(value = "/get-all-users", method = RequestMethod.GET)
    public @ResponseBody Object getAllUsers() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Object> usernames = sqlSession.selectList("backend.lab3.mybatis.config.mapper.UserMapper.getAllUsernames");
        sqlSession.close();

        return usernames;
    }

}

