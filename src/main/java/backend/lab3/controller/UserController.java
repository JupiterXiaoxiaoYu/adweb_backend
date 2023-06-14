package backend.lab3.controller;

import backend.lab3.mybatis.SqlSessionLoader;
import backend.lab3.mybatis.po.User;
import backend.lab3.mybatis.po.account;
import backend.lab3.mybatis.po.trade;
import backend.lab3.request.*;
import backend.lab3.response.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Object register(@RequestBody UserRegisterRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findUserByName", request.getName());
        if (user != null) {
            sqlSession.close();
            return new ErrorResponse("The username is already used");
        } else {
            String image;
            if (request.getImage()==null)
            {image= request.getImage();}//换自动生成
            else  image= request.getImage();
            sqlSession.insert("backend.lab3.mybatis.config.mapper.UserMapper.addUser",
                    new User(request.getGender(), request.getName(), request.getPassword(), request.getBirthday(), image));
            sqlSession.commit();
            User user1=sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findUserByName",request.getName());
            sqlSession.insert("backend.lab3.mybatis.config.mapper.UserMapper.addaccount", new account(user1.getUserID(), 0));
            sqlSession.commit();
            sqlSession.close();
            return new UserRegisterResponse("Register Successfully!");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Object login(@RequestBody UserLoginRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findUserByName", request.getUsername());
        if (user == null) {
            sqlSession.close();
            return new ErrorResponse("The username not exists, please register first");
        } else if (!user.getPassword().equals(request.getPassword())) {
            sqlSession.close();
            return new ErrorResponse("Incorrect password");
        }else{
            sqlSession.close();
             UserLoginResponse out= new UserLoginResponse("Login Successfully!",user);
             return  out;
        }
    }

    @RequestMapping(value = "/get-all-users", method = RequestMethod.GET)
    public @ResponseBody Object getAllUsers() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Object> usernames = sqlSession.selectList("backend.lab3.mybatis.config.mapper.UserMapper.getAllNames");
        sqlSession.close();

        return usernames;
    }

    @RequestMapping(value = "/changeinfo", method = RequestMethod.POST)
    public @ResponseBody Object changeUsers(@RequestBody EditRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();

        User user1=sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findUserByName",request.getName());
        User user2=new User(request.getUserID(),  request.getName(), request.getPassword(), request.getBirthday(), request.getImage(),request.getGender());
        if (user1==null) {
            sqlSession.update("backend.lab3.mybatis.config.mapper.UserMapper.updateUser", user2);
            sqlSession.commit();
            sqlSession.close();

            return new UserRegisterResponse("change info successfully!");

        } else if (user1.getUserID()==request.getUserID()) {
            sqlSession.update("backend.lab3.mybatis.config.mapper.UserMapper.updateUser", user2);
            sqlSession.commit();
            sqlSession.close();

            return new UserRegisterResponse("change info successfully");
        }else{
            sqlSession.close();
            return new UserRegisterResponse("this name has been occupied");
        }

    }

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public @ResponseBody Object accountUsers(@RequestBody accountRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();

        account account=sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findAccountByID",
                request.getUserID());
        if(request.getFunds()>0) {
            sqlSession.update("backend.lab3.mybatis.config.mapper.UserMapper.updateaccount",
                    new account(request.getUserID(), request.getFunds() + account.getFunds()));
            sqlSession.commit();

            ZoneId shanghaiZone = ZoneId.of("Asia/Shanghai");

            // 获取当前时间
            LocalDateTime currentTime = LocalDateTime.now();

            // 将当前时间转换为上海时区的时间
            ZonedDateTime shanghaiTime = ZonedDateTime.of(currentTime, shanghaiZone);

            // 格式化日期和时间为字符串
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String shanghaiTimeString = shanghaiTime.format(formatter);
            String des = shanghaiTimeString + "   charge ";


            trade trade = new trade(request.getUserID(), 0, request.getFunds(), des);
            sqlSession.insert("backend.lab3.mybatis.config.mapper.UserMapper.addtrade", trade);
            sqlSession.commit();
        }




        account account1=sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findAccountByID",
                request.getUserID());
        sqlSession.close();



    return account1;}


    @RequestMapping(value = "/getaccount", method = RequestMethod.POST)
    public @ResponseBody Object findaccountUsers(@RequestParam int userID) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        account account=sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findAccountByID", userID);

        sqlSession.close();
        accountResponse re=new accountResponse(account,"success");



        return re;}


    @RequestMapping(value = "/get_trade_record", method = RequestMethod.POST)
    public @ResponseBody Object getTrades(@RequestParam int userID)throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<trade> trades1 = sqlSession.selectList("backend.lab3.mybatis.config.mapper.UserMapper.getTradesByUserinID",userID);
        List<trade> trades2 = sqlSession.selectList("backend.lab3.mybatis.config.mapper.UserMapper.getTradesByUseroutID",userID);
        sqlSession.close();
        tradeResponse response=new tradeResponse(trades1,trades2,"success");

        return response;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public @ResponseBody Object getInfo(@RequestParam int userID)throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user= sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findUserById",userID);

        sqlSession.close();


        return user;
    }





}

