package backend.lab3.controller;

import backend.lab3.mybatis.SqlSessionLoader;

import backend.lab3.request.UserCurationRequest;
import backend.lab3.request.UserShopRequest;
import backend.lab3.request.AddNftRequest;
import backend.lab3.response.ErrorResponse;
import backend.lab3.response.GeneralResponse;
import org.apache.ibatis.session.SqlSession;
import backend.lab3.mybatis.po.Nft;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    
}
