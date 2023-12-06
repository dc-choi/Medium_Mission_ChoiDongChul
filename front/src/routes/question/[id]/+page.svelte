<script lang="ts">
    export let data;

    let detail = data.json;

    let content: string = '';

    const addAnswer = () => {
        alert('답변이 추가되었습니다.');
    };
</script>

<div class="container my-3">
    <!-- 질문 -->
    <h2 class="border-bottom py-2">{detail.subject}</h2>
    <div class="card my-3">
        <div class="card-body">
            <div class="card-text" style="white-space: pre-line;">{detail.content}</div>
            <div class="d-flex justify-content-end">
                <div class="badge bg-light text-dark p-2 text-start">
                    <div class="mb-2">
                        {#if detail.siteUser != null}
                        <span>{detail.siteUser.username}</span>
                        {/if}
                    </div>
                    <div>{detail.createDate}</div>
                </div>
            </div>
            <div class="my-3">
                <!-- 추후에 수정을 추가할 예정 -->
            </div>
        </div>
    </div>
    <!-- 답변의 갯수 표시 -->
    <h5 class="border-bottom my-3 py-2">{detail.answers.size()} 개의 답변이 있습니다.</h5>
    <!-- 답변 반복 시작 -->
    <div class="card my-3">
        {#each detail.answers as answer}
        <div class="card-body">
            <div class="card-text" style="white-space: pre-line;">{answer.content}</div>
            <div class="d-flex justify-content-end">
                <div class="badge bg-light text-dark p-2 text-start">
                    <div class="mb-2">
                        {#if answer.siteUser != null}
                        <span>{answer.siteUser.username}</span>
                        {/if}
                    </div>
                    <div>{answer.createDate}</div>
                </div>
            </div>
        </div>
        {/each}
    </div>
    <!-- 답변 반복 끝  -->
    <!-- 답변 작성 -->
    <input type="hidden" name="questionId" bind:value="{detail.id}">
    <textarea disabled class="form-control" rows="10" bind:value={content} ></textarea>
    <textarea class="form-control" rows="10" bind:value={content}></textarea>
    <input type="button" on:click={addAnswer} value="답변등록" class="btn btn-primary my-2">
</div>
