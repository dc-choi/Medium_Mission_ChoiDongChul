<script lang="ts">
    const add = () => {
        alert('질문이 추가되었습니다.');
    };
</script>

<div class="container my-3">
    <table class="table table-sm">
        <thead>
            <tr>
                <td>제목</td>
                <td>내용</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <input type="text" id="subject">
                </td>
                <td>
                    <input type="text" id="content">
                </td>
            </tr>
        </tbody>
    </table>
    <button type="button" on:click={add} class="btn btn-primary my-2">
</div>

