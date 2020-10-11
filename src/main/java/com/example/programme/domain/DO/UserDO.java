package com.example.programme.domain.DO;

import java.time.LocalDateTime;

/**
 * @author lingjun.jlj
 * @date: 2018/4/2
 */
public class UserDO {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String card;
    private String phone;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


    public static final class UserDOBuilder {
        private Long id;
        private String name;
        private String password;
        private Integer age;
        private String card;
        private String phone;
        private Integer status;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;

        private UserDOBuilder() {
        }

        public static UserDOBuilder anUserDO() {
            return new UserDOBuilder();
        }

        public UserDOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserDOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserDOBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDOBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public UserDOBuilder withCard(String card) {
            this.card = card;
            return this;
        }

        public UserDOBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserDOBuilder withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public UserDOBuilder withCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        public UserDOBuilder withUpdateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public UserDO build() {
            UserDO userDO = new UserDO();
            userDO.setId(id);
            userDO.setName(name);
            userDO.setPassword(password);
            userDO.setAge(age);
            userDO.setCard(card);
            userDO.setPhone(phone);
            userDO.setStatus(status);
            userDO.setCreateTime(createTime);
            userDO.setUpdateTime(updateTime);
            return userDO;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", card='" + card + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
