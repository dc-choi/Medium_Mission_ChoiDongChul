<script lang="ts">
    import { user } from "$lib/user";

    const logout = () => {
        user.logout();
        alert('로그아웃 되었습니다.');
    };
</script>

<header>
    <head>
        <title>Medium</title>
    </head>

    <nav>
        <div>
            <a href="/">Medium</a>
            <div>
                <ul>
                    <li>
                        {#if !$user}
                        <a href="/login">로그인</a>
                        {:else if $user}
                        <a href="/" on:click={logout}>로그아웃</a>
                        {/if}
                    </li>
                    <li>
                        <a href="/user">회원가입</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
