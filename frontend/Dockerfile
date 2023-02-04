FROM node:16.14.2-alpine AS BASE
WORKDIR /app
COPY package.json package-lock.json ./
RUN apk add --no-cache libc6-compat
RUN npm ci

FROM node:16.14.2-alpine AS BUILD
WORKDIR /app
COPY --from=BASE /app/node_modules ./node_modules
COPY . .
RUN apk add --no-cache libc6-compat
RUN npm run build
RUN cd .next/standalone
RUN npm prune

FROM node:16.14.2-alpine AS PRODUCTION
WORKDIR /app
COPY --from=BUILD /app/package-lock.json ./
COPY --from=BUILD /app/public ./public
COPY --from=BUILD /app/next.config.js ./
COPY --from=BUILD /app/.next/standalone ./
COPY --from=BUILD /app/.next/static ./.next/static

EXPOSE 3000

CMD ["npm", "run", "start"]
