package backend.lab3.controller;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import backend.lab3.mybatis.SqlSessionLoader;
import backend.lab3.mybatis.po.*;
import backend.lab3.request.UserGeneralRequest;
import backend.lab3.request.AddNftRequest;
import backend.lab3.request.GetAllNftRequest;
import backend.lab3.request.SingleNftRequest;
import backend.lab3.request.ListNftRequest;
import backend.lab3.request.UnlistNftRequest;
import backend.lab3.request.ModiftyNftPriceRequest;
import backend.lab3.request.BuyNftRequest;

import backend.lab3.response.ErrorResponse;
import backend.lab3.response.GeneralResponse;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import jakarta.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/nft")
public class NftController {

    @RequestMapping(value = "/add-nft", method = RequestMethod.POST)
    public @ResponseBody Object addNft(@RequestBody AddNftRequest request) throws IOException {
        System.out.println(request.getNftName());
        System.out.println(request.getNftDescription());
        System.out.println(request.getNftImage());
        System.out.println(request.getNftOwner());
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.insert("backend.lab3.mybatis.config.mapper.NftMapper.addNft",
                new Nft(request.getNftName(), request.getNftDescription(), request.getNftImage(), request.getNftOwner())
                );
        sqlSession.commit();
        sqlSession.close();
        return new GeneralResponse("Add Successfully!");
    }



    @RequestMapping(value = "/nfts", method = RequestMethod.GET)
    public @ResponseBody Object getAllNfts(GetAllNftRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        if(request.getKeywords()!=null){
            List<Object> nfts = sqlSession.selectList("backend.lab3.mybatis.config.mapper.NftMapper.findNftsByKeywords", request.getKeywords());
            sqlSession.close();
            return nfts;
        }else if(request.getNftStatus()!=null){
            List<Object> nfts = sqlSession.selectList("backend.lab3.mybatis.config.mapper.NftMapper.findNftsByStatus", request.getNftStatus());
            sqlSession.close();
            return nfts;
        }else if(request.getNftOwner()!=null){
            List<Object> nfts = sqlSession.selectList("backend.lab3.mybatis.config.mapper.NftMapper.findNftsByOwner", request.getNftOwner());
            sqlSession.close();
            return nfts;
        }else{
            List<Object> nfts = sqlSession.selectList("backend.lab3.mybatis.config.mapper.NftMapper.findAllNfts");
            sqlSession.close();
            return nfts;
        }
    }

    @RequestMapping(value = "/nft", method = RequestMethod.GET)
    public @ResponseBody Object getNft(SingleNftRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Nft nft = sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.findNftById", request.getNftID());
        sqlSession.close();
        return nft;
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public @ResponseBody Object getUserShop(UserGeneralRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        System.out.println(request.getUserID());
        List<Object> nfts = sqlSession.selectList("backend.lab3.mybatis.config.mapper.NftMapper.getShopItemByUserId", request.getUserID());
        sqlSession.close();
        return nfts;
    }

    @RequestMapping(value = "/curations", method = RequestMethod.GET)
    public @ResponseBody Object getUserCuration(UserGeneralRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        System.out.println(request.getUserID());
        List<Object> nfts = sqlSession.selectList("backend.lab3.mybatis.config.mapper.NftMapper.getCurationItemByUserId", request.getUserID());
        sqlSession.close();
        return nfts;
    }

    @RequestMapping(value = "/curate-nft", method = RequestMethod.POST)
    public @ResponseBody Object curateNft(HttpServletRequest httpRequest, @RequestBody SingleNftRequest request) throws IOException {
        System.out.println(request.getNftID());
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        String userId = httpRequest.getHeader("userID");
        if(sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.getCurationItemByNftID", request.getNftID())!=null){
            sqlSession.close();
            return new ErrorResponse("NFT is already curated!");
        }
        sqlSession.insert("backend.lab3.mybatis.config.mapper.NftMapper.curateNft", new CurationItem(Integer.parseInt(userId), request.getNftID()));
        sqlSession.commit();
        sqlSession.close();
        return new GeneralResponse("Curate Successfully!");
    }

    @RequestMapping(value = "/list-nft", method = RequestMethod.POST)
    public @ResponseBody Object modifyNftStatus(@RequestBody ListNftRequest request, HttpServletRequest httpRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        String userId = httpRequest.getHeader("UserID");
        System.out.println(request.getPrice());
        System.out.println(request.getNftID());
        if(sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.getShopItemByNftID", request.getNftID())!=null){
            sqlSession.close();
            return new ErrorResponse("NFT is already listed!");
        }
        sqlSession.update("backend.lab3.mybatis.config.mapper.NftMapper.listNft", request);
        sqlSession.insert("backend.lab3.mybatis.config.mapper.NftMapper.addShopItem", new ShopItem(Integer.parseInt(userId), request.getNftID(), request.getPrice()));
        sqlSession.commit();
        sqlSession.close();
        return new GeneralResponse("Modify Successfully!");
    }

    @RequestMapping(value = "/unlist-nft", method = RequestMethod.POST)
    public @ResponseBody Object unlistNft(@RequestBody UnlistNftRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        if(sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.getShopItemByNftID", request.getNftID())==null){
            sqlSession.close();
            return new ErrorResponse("NFT is not listed!");
        }
        sqlSession.update("backend.lab3.mybatis.config.mapper.NftMapper.unlistNft", request.getNftID());
        sqlSession.delete("backend.lab3.mybatis.config.mapper.NftMapper.deleteShopItem", request.getNftID());
        sqlSession.commit();
        sqlSession.close();
        return new GeneralResponse("Unlist Successfully!");
    }

    @RequestMapping(value = "/uncurate-nft", method = RequestMethod.POST)
    public @ResponseBody Object uncurateNft(@RequestBody SingleNftRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        if(sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.getCurationItemByNftID", request.getNftID())==null){
            sqlSession.close();
            return new ErrorResponse("NFT is not curated!");
        }
        sqlSession.delete("backend.lab3.mybatis.config.mapper.NftMapper.uncurateNft", request.getNftID());
        sqlSession.commit();
        sqlSession.close();
        return new GeneralResponse("Uncurate Successfully!");
    }


    @RequestMapping(value = "/modify-price", method = RequestMethod.POST)
    public @ResponseBody Object modifyPrice(@RequestBody ModiftyNftPriceRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        System.out.println(request.getPrice());
        System.out.println(request.getNftID());
        if(request.getPrice()<=0){
            sqlSession.close();
            return new ErrorResponse("Price must be positive!");
        }else if(sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.getShopItemByNftID", request.getNftID())==null){
            sqlSession.close();
            return new ErrorResponse("NFT is not listed!");
        }
        sqlSession.update("backend.lab3.mybatis.config.mapper.NftMapper.modifyListedPrice", request);
        sqlSession.commit();
        sqlSession.close();
        return new GeneralResponse("Modify Successfully!");
    }

    @RequestMapping(value = "/buy-nft", method = RequestMethod.POST)
    public @ResponseBody Object buyNft(@RequestBody BuyNftRequest request, HttpServletRequest httpRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        String userId = httpRequest.getHeader("userID");
        int id=Integer.parseInt(userId);
        System.out.println(request.getNftID());
        ShopItem nft = sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.getShopItemByNftID", request.getNftID());
        if (nft == null) {
            sqlSession.close();
            return new ErrorResponse("NFT is not listed!");
        } else if (nft.getNftPrice() <= 0) {
            sqlSession.close();
            return new ErrorResponse("Price must be positive!");
        } else if (((Nft) sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.findNftById", request.getNftID())).getNftOwner() == userId) {
            sqlSession.close();
            return new ErrorResponse("You can't buy your own NFT!");
        } else {


            account account1=sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findAccountByID",id);
            account account2=sqlSession.selectOne("backend.lab3.mybatis.config.mapper.UserMapper.findAccountByID",nft.getuserID());
            if (nft.getNftPrice()>account1.getFunds()){
                return new GeneralResponse("you do not have enough money in account!");}
            else{
                sqlSession.update("backend.lab3.mybatis.config.mapper.UserMapper.updateaccount",
                        new account(id, account1.getFunds()- nft.getNftPrice()));
                sqlSession.update("backend.lab3.mybatis.config.mapper.UserMapper.updateaccount",
                        new account(account2.getUserID(), account2.getFunds()+nft.getNftPrice()));
                Nft nft1=sqlSession.selectOne("backend.lab3.mybatis.config.mapper.NftMapper.findNftById",nft.getnftID());

                ZoneId shanghaiZone = ZoneId.of("Asia/Shanghai");

                // 获取当前时间
                LocalDateTime currentTime = LocalDateTime.now();

                // 将当前时间转换为上海时区的时间
                ZonedDateTime shanghaiTime = ZonedDateTime.of(currentTime, shanghaiZone);

                // 格式化日期和时间为字符串
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String shanghaiTimeString = shanghaiTime.format(formatter);
                String des=shanghaiTimeString+"   collectibles Trade:"+nft1.getNftName();







                trade trade=new trade(account2.getUserID(),account1.getUserID(),nft.getNftPrice(),des);
                sqlSession.insert("backend.lab3.mybatis.config.mapper.UserMapper.addtrade",trade);
                sqlSession.update("backend.lab3.mybatis.config.mapper.NftMapper.buyNft", request.getNftID());
            sqlSession.delete("backend.lab3.mybatis.config.mapper.NftMapper.deleteShopItem", request.getNftID());
            sqlSession.commit();
            sqlSession.close();
            return new GeneralResponse("Buy Successfully!");
        }}
    }



}
