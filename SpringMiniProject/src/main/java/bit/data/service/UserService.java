package bit.data.service;

import bit.data.dao.UserDaoInter;
import bit.data.dto.UserDto;
import bit.data.dto.UserLecJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserServiceInter{

    @Autowired
    UserDaoInter userDao;

    @Override
    public int getUserTotalCount(String searchword) {
        Map<String, String> map = new HashMap<>();
        map.put("searchword", searchword);

        return userDao.getTotalUserCount(map);
    }

    @Override
    public List<UserDto> getUserList(String searchword, int startnum, int perpage) {
        Map<String, Object> map = new HashMap<>();
        map.put("searchword", searchword);
        map.put("startnum", startnum);
        map.put("perpage", perpage);

        return userDao.getUserList(map);
    }

    @Override
    public UserDto getUserDetailbyManager(int usernum) {
        return userDao.getUserDetailbyManager(usernum);
    }

    @Override
    public UserDto getDataByNum(int usernum) {
        return userDao.getDataByNum(usernum);
    }

    @Override
    public UserDto getDataById(String email) {
        return userDao.getDataById(email);
    }

    @Override
    public List<UserLecJoinDto> getUserLecJoin(int usernum) {
        return userDao.getUserLecJoin(usernum);
    }

    @Override
    public void updateUserPhoto(int usernum, String userphoto) {
        Map<String, Object> map= new HashMap<>();
        map.put("usernum",usernum);
        map.put("userphoto",userphoto);
        userDao.updateUserPhoto(map);
    }

    @Override
    public void deleteUserPhoto(int usernum) {
        userDao.deleteUserPhoto(usernum);
    }

    @Override
    public void updateUser(UserDto dto) {
        userDao.updateUser(dto);
    }

    @Override
    public void deleteUser(int usernum) {
        userDao.deleteUser(usernum);
    }
}
