import { SERVER_URL } from "$env/static/private";

export async function load() {
    const response = await fetch(`${SERVER_URL}/v1/questions`);
    const json = await response.json();

    return {
        json
    }
}
