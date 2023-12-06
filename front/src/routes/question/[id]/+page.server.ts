import { SERVER_URL } from "$env/static/private";

export async function load({ params }) {
    const response = await fetch(`${SERVER_URL}/v1/questions/${params.id}`);
    const json = await response.json();

    return {
        json
    }
}
