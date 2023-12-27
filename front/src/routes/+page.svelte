<script lang="ts">
</script>

<div>
    <table>
        <thead>
            <tr>
                <th>게시글 번호</th>
                <th style="width:50%">제목</th>
                <th>글쓴이</th>
                <th>작성일시</th>
            </tr>
        </thead>
        <tbody>
            {#each [1,2,3,4,5,6,7,8,9,10] as item}
            <tr>
                <td>{item}</td>
                <td>제목</td>
                <td>글쓴이</td>
                <td>작성일시</td>
            </tr>
            {/each}
        </tbody>
    </table>
</div>
