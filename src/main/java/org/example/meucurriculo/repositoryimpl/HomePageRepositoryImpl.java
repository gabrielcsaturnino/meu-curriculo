package org.example.meucurriculo.repositoryimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.meucurriculo.RedisUtil;
import org.example.meucurriculo.models.HomePage;
import org.example.meucurriculo.models.Project;
import org.example.meucurriculo.repository.HomePageRepository;
import redis.clients.jedis.Jedis;

import java.util.List;

public class HomePageRepositoryImpl implements HomePageRepository {
    private static final ObjectMapper objMapper = new  ObjectMapper();


    @Override
    public void saveHomePage(HomePage homePage) {
        try (Jedis jedis = RedisUtil.getConnection()){
            String homeJson = objMapper.writeValueAsString(homePage);
            jedis.set("homePage", homeJson);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HomePage getHomePage(String id) {

        try (Jedis jedis = RedisUtil.getConnection()){
            String homeJson = jedis.get(id);
            return objMapper.readValue(homeJson, HomePage.class);
            }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Project> getListProject(){
        return List.of();
    }
}
