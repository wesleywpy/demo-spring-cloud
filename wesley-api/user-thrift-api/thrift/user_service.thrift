namespace java com.wesley.thrift.user

struct UserDTO {
    1:i32 id,
    2:string username,
    3:string password,
    4:string realName,
    5:string mobile,
    6:string email,
    7:string intro,
    8:i32 stars
}

service UserService {

    UserDTO getUserById(1:i32 id);

    UserDTO getTeacherById(1:i32 id);

    UserDTO getUserByName(1:string username);

    void regiserUser(1:UserDTO userInfo);

}