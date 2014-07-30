namespace java com.weibo.newbie.thrift

struct User {
	1: i64 uid,
	2: string uname
}

service UserService {
	User getUser(1: i64 id)
}