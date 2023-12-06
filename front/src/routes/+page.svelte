<script lang="ts">
    export let data;

    let json = data.json;
</script>

<div class="container my-3">
    <table class="table">
        <thead class="table-dark">
            <tr class="text-center">
                <th>게시글 번호</th>
                <th style="width:50%">제목</th>
                <th>글쓴이</th>
                <th>작성일시</th>
            </tr>
        </thead>
        <tbody>
            {#each json as question}
            <tr class="text-center">
                <td>{question.getTotalElements - (question.number * question.size) - question.index}</td>
                <td class="text-start">
                    <a href="/v1/question/${question.id}">{question.subject}</a>
                    {#if question.answers.size() > 0}
                    <span class="text-danger small ms-2">
                        {question.answers.size()}
                    </span>
                    {/if}
                </td>
                <td>
                    {#if question.siteUser != null}
                    <span>{question.siteUser.username}</span>
                    {/if}
                </td>
                <td>{question.createDate}</td>
            </tr>
            {/each}
        </tbody>
    </table>
    <a href="/question">질문 추가</a>
</div>
