<form action="login" method="post">
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <h2>Tạo tài khoản mới</h2>
    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>
    <section>
        <!-- Tên tài khoản -->
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control">
            </div>
        </label>

        <!-- Mật khẩu -->
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" placeholder="Mật khẩu" name="password" class="form-control">
            </div>
        </label>

        <!-- Remember me -->
        <div class="checkbox">
            <label>
                <input type="checkbox" name="rememberMe"> Ghi nhớ tôi
            </label>
        </div>
    </section>

    <!-- Nút đăng nhập -->
    <button type="submit" class="btn btn-primary">Đăng nhập</button>
</form>