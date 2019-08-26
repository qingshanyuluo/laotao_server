# laotao_server
老饕餮服务端


## 后端api接口

### 1). 用户

1. 注册 POST 192.168.137.97:8080/register?email=501002251@qq.com&password=12qwas&displayName=装逼大佬

   ```json
   {
       "code": 200,
       "msg": "success",
       "data": true
   }
   ```

   

2. 登录 POST 192.168.137.97:8080/login?email=501002251@qq.com&password=12qwas

   ```json
   {
       "code": 200,
       "msg": "success",
       "data": true
   }
   ```

   

3. 验证码(暂无)

4. 游客登录

5. 修改个人信息

### 2). 查找店铺



### 3). 添加店铺

### 4). 评价店铺

- 获得所有评论: get 192.168.137.97:8080/shop/{shopId}/comments

  ```json
  {
      "code": 200,
      "msg": "success",
      "data": {
          "content": [
              {
                  "id": 1,
                  "content": "jjjjjjjjjjjjjjjjjjjjjjj",
                  "liked": 21,
                  "userId": 1,
                  "shop": {
                      "id": 1,
                      "name": "haidilao",
                      "location": "tianjin",
                      "cost": 70,
                      "rankStar": 4,
                      "type": "huoguo",
                      "liked": 355,
                      "uploaderId": 1
                  }
              },
              {
                  "id": 2,
                  "content": "jjjjjjjjjjjfsafsdafasdfjjjjjjjjjjjj",
                  "liked": 21,
                  "userId": 2,
                  "shop": {
                      "id": 1,
                      "name": "haidilao",
                      "location": "tianjin",
                      "cost": 70,
                      "rankStar": 4,
                      "type": "huoguo",
                      "liked": 355,
                      "uploaderId": 1
                  }
              },
              {
                  "id": 3,
                  "content": "jjjjjjjjjjjfsafsdafasdfjjjjjjfdsfsafsafasjjjjjj",
                  "liked": 21,
                  "userId": 2,
                  "shop": {
                      "id": 1,
                      "name": "haidilao",
                      "location": "tianjin",
                      "cost": 70,
                      "rankStar": 4,
                      "type": "huoguo",
                      "liked": 355,
                      "uploaderId": 1
                  }
              },
              {
                  "id": 4,
                  "content": "jjjjjjjjjjjfsafafafafafafsdafasdfjjjjjjfdsfsafsafasjjjjjj",
                  "liked": 21,
                  "userId": 2,
                  "shop": {
                      "id": 1,
                      "name": "haidilao",
                      "location": "tianjin",
                      "cost": 70,
                      "rankStar": 4,
                      "type": "huoguo",
                      "liked": 355,
                      "uploaderId": 1
                  }
              },
              {
                  "id": 5,
                  "content": "jjjjjjjjjjjfsafafafafafafsdafasdfjjjjjjfdsfsafsafasjjjjjj",
                  "liked": 21,
                  "userId": 2,
                  "shop": {
                      "id": 1,
                      "name": "haidilao",
                      "location": "tianjin",
                      "cost": 70,
                      "rankStar": 4,
                      "type": "huoguo",
                      "liked": 355,
                      "uploaderId": 1
                  }
              }
          ],
          "pageable": {
              "sort": {
                  "sorted": false,
                  "unsorted": true,
                  "empty": true
              },
              "offset": 0,
              "pageSize": 20,
              "pageNumber": 0,
              "paged": true,
              "unpaged": false
          },
          "totalPages": 1,
          "totalElements": 5,
          "last": true,
          "size": 20,
          "number": 0,
          "sort": {
              "sorted": false,
              "unsorted": true,
              "empty": true
          },
          "first": true,
          "numberOfElements": 5,
          "empty": false
      }
  }
  ```

  

- 添加评价: post 192.168.137.97:8080/shop/{shopId}/comments 

    ```json
    {
        "content": "jjjjjjjjjjjfsafsdafasdfjjjjjjfdsfsafsafasjjjjjj",
        "liked": 21,
        "userId": 2
    }
    ```

    ```json
    {
        "code": 200,
        "msg": "success",
        "data": {
            "id": 5,
            "content": "jjjjjjjjjjjfsafafafafafafsdafasdfjjjjjjfdsfsafsafasjjjjjj",
            "liked": 21,
            "userId": 2,
            "shop": {
                "id": 1,
                "name": "haidilao",
                "location": "tianjin",
                "cost": 70,
                "rankStar": 4,
                "type": "huoguo",
                "liked": 355,
                "uploaderId": 1
            }
        }
    }
    ```





-------
