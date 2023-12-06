<script lang="ts">
    import { user } from "$lib/user";

    let error = false;

    const login = () => {
        user.login();
        alert('로그인 되었습니다.');
    };
</script>

<div class="container my-3">
    {#if error}
    <div>
        <div class="alert alert-danger">
            사용자ID 또는 비밀번호를 확인해 주세요.
        </div>
    </div>
    {/if}
    <div class="mb-3">
        <label for="username" class="form-label">사용자ID</label>
        <input type="text" id="username" class="form-control">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">비밀번호</label>
        <input type="password" id="password" class="form-control">
    </div>
    <button type="button" on:click={login} class="btn btn-primary">로그인</button>
</div>
