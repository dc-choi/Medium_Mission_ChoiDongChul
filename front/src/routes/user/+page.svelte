<script lang="ts">
    const signup = () => {
        alert('회원가입 되었습니다.');
    };
</script>

<div class="container my-3">
    <div class="my-3 border-bottom">
        <div>
            <h4>회원가입</h4>
        </div>
    </div>
    <div class="mb-3">
        <label class="form-label">사용자ID</label>
        <input type="text" class="form-control" value="">
    </div>
    <div class="mb-3">
        <label class="form-label">비밀번호</label>
        <input type="password" class="form-control" value="">
    </div>
    <div class="mb-3">
        <label class="form-label">비밀번호 확인</label>
        <input type="password" class="form-control" value="">
    </div>
    <div class="mb-3">
        <label class="form-label">이메일</label>
        <input type="email" class="form-control" value="">
    </div>
    <button type="button" on:click={signup} class="btn btn-primary">회원가입</button>
</div>
