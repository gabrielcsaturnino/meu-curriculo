package org.example.meucurriculo.repositoryimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.meucurriculo.RedisUtil;
import org.example.meucurriculo.models.Project;
import org.example.meucurriculo.repository.ProjectRepository;
import org.example.meucurriculo.services.ProjectService;
import redis.clients.jedis.Jedis;


public class ProjectRepositoryImpl implements ProjectRepository {
    private static final ObjectMapper objMapper = new  ObjectMapper();





    @Override
    public void saveProject(Project project) {

        try(Jedis jedis = new RedisUtil().getConnection()){
            String projectJson = objMapper.writeValueAsString(project);
            jedis.set(project.getId(), projectJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Project getProject(String id) {
        try(Jedis jedis = new RedisUtil().getConnection()){
            String projectJson = jedis.get(id);
            if(projectJson != null) {
                return objMapper.readValue(projectJson, Project.class);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
